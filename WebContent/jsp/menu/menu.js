/**
 * 全局变量$menu和$method
 * 这两个变量是为了让create和edit的方法公用的变量，目的是为了让
 * 增加和编辑方法公用同一个$("#submit")方法
 */
var $url;
var $method = "POST";
var cur_node = undefined;

/**
 * 点击增加按钮的时候打开白哦单的对话框
 */
function create(){
	clearForm();
	$("#del_flag").val("0");
	$('#increment_id').attr("disabled","disabled");
	$url = contextPath + "/savemenu.do";
	$method = "POST";
}

function edit(){
	$('#increment_id').attr("disabled",false);
	$url = contextPath + "/updatemenu.do";
	$method = "POST";
}

function remove(){
	$('#increment_id').attr("disabled",false);
	if(valueIsEmpty(cur_node)){
		alert("请在左边的菜单中点击需要删除的菜单");
	}else{
		if(cur_node.children!=null){
			if(cur_node.children.length>0){
				alert("该菜单下有子菜单，请先删除子菜单");
			}else{//当节点的children等于0时无子节点，则该父节点也可删除
				$("#del_flag").val("1");
				$url = contextPath + "/deletemenu.do";
				$method = "POST";
//				alert("删除");
				$("#submit").click();
			}
		}else{
			$("#del_flag").val("1");
			$url = contextPath + "/deletemenu.do";
			$method = "POST";
//			alert("删除");
			$("#submit").click();
		}
	}
}

/**
 * 载入左边的已有菜单
 */
function loadMenuTree(){
	$('#menu_tree').tree({
		animate: true, 
		url:  contextPath +'/menutree.do',
		multiple : true,
		lines : true,
		cascadeCheck : false,
		formatter : function(node){
			if(node.attributes.father_id == null){
				return 0+"."+node.text;
			}else{
				if(valueIsNotEmpty(node.attributes.sort)){
					var sort = node.attributes.sort;
					index = sort.substring(sort.indexOf(".")+1);
					$("#sort").textbox("setValue",index);
					return index+"."+node.text;
				}else{
					return node.text;
				}
			}
			
		},
		onLoadSuccess : function(node, data){
			$('#menu_tree').tree("expandAll",node);
			clearForm();
			cur_node = undefined;
		},
		onSelect : function(node){
//			console.info(node);
			cur_node = node;
			if(node.attributes.father_id == null){
				create();
			}else{
				$("#form").form("load",node.attributes);
				if(valueIsNotEmpty(node.attributes.sort)){
					var sort = node.attributes.sort;
					index = sort.substring(sort.indexOf(".")+1);
					$("#sort").textbox("setValue",index);
				}
				edit();
			}
			if(valueIsNotEmpty(cur_node.text)){
//				$("#father_menu").textbox("setValue",cur_node.text);
				loadMenu();
			}else{
				$.messager.show({
					title : '提示信息：',
					msg : "cur_node的text为空"
				});
			}
		}
	});
}

//function loadLevelOneMenu(){
//	$.ajax({
//        type: "POST",
//        contentType: "application/json",
//        url: contextPath + '/listlevelonemenu.do',
//        dataType: 'json',
//        success: function(result) {
//            $('#father_id').combobox({
//                data: result.rows,
//                valueField: 'menu_id',
//                textField: 'menu_name',
//                width : 120,
//                required : true,
//                onSelect: function(record) {
//                	console.info(record);
//                	if(record.father_id == "null"||record.father_id == null){
//                		$("#menu_level").val("1");
//                	}
//                	if(record.father_id == "0"){
//                		$("#menu_level").val("2");
//                	}
//                }
//            }).combobox('clear');
//        }
//    });
//}

/**
 * 载入textbox打开的dialog中的tree
 */
function loadMenu(){
	$('#select_menu').tree({
//		animate: true, 
		url:  contextPath +'/menutree.do',
		multiple : true,
		lines : true,
		cascadeCheck : false,
		formatter : function(node){
			if(node.attributes.father_id == null){
				return 0+"."+node.text;
			}else{
				if(valueIsNotEmpty(node.attributes.sort)){
					var sort = node.attributes.sort;
					index = sort.substring(sort.indexOf(".")+1);
					return index+"."+node.text;
				}else{
					return node.text;
				}
			}
			
		},
		onLoadSuccess : function(node, data){
			$('#select_menu').tree("expandAll",node);
			if($("#father_id").val() != undefined){//如果是编辑状态，则自动选中父项菜单
				var selected_id = $("#father_id").val();
				if(valueIsNotEmpty(selected_id)){
					console.info(selected_id);
					var selected_node = $("#select_menu").tree("find",selected_id);
					console.info(selected_node);
					$("#select_menu").tree("select",selected_node.target);
				}
			}
		},
		onSelect : function(node){
//			console.info(node);
//			cur_node = node;
			if(valueIsNotEmpty(node.attributes.menu_id)){//设置父菜单id
				$("#father_id").val(node.attributes.menu_id);
			}else{
				if(node.attributes.menu_id == 0){//当menu_id为0时，需要特殊处理
					$("#father_id").val("0");
				}else{
					$.messager.show({
						title : '提示信息：',
						msg : "father_id获取失败！"
					});
				}
			}
			if(valueIsNotEmpty(node.attributes.menu_name)){//设置显示菜单的名称
				$("#father_menu").textbox("setText",node.attributes.menu_name);
			}else{
				$.messager.show({
					title : '提示信息：',
					msg : "menu_name获取失败！"
				});
			}
			if(valueIsNotEmpty(node.attributes.menu_level)){//计算菜单级别
				try{
					var father_level = parseInt(node.attributes.menu_level);//js转数字
					var level = father_level + 1;
					$("#menu_level").val(level);
				}catch(e){
					$.messager.show({
						title : '提示信息：',
						msg : "menu_level转换失败！" + e
					});
				}
			}else{
				$.messager.show({
					title : '提示信息：',
					msg : "menu_level获取失败！"
				});
			}
		}
	});
}

function clearForm(){
	$("#form").form("clear");
}

$(function(){

	$(".easyui-textbox").textbox({
		width : 400
	});
	
	$("#update_by").textbox({
		width : 200
	});
	
	$("#update_time").textbox({
		width : 200
	});
	
	$("#father_menu").textbox({
		iconWidth : 30,
		icons: [{
            iconCls: 'icon-search',
            handler: function (e) {
            	loadMenu();
            	$('#dialog').window({
            		left:(document.body.offsetWidth-400)+"px", top:((document.body.offsetHeight-450)/2)+"px"
            	});
            	$('#dialog').dialog('open').dialog('setTitle', '选择菜单');
            }
        }],
		editable : false,
		width : 150,
		prompt : "点击选择父菜单"
	});
	
	loadMenuTree();
//	loadLevelOneMenu();
	
	create();
	
	/* 给linkbutton绑定操作； */
//	循环便利所有class为easyui-linkbutton的按钮
	$(".easyui-linkbutton").each(function(){
//		为当前按钮绑定点击事件
		$(this).unbind('click').bind('click', function(){
//			获取当前按钮的iconCls的值，根据值来判断菜单点击了什么按钮
			var currIcon=$(this).attr("iconCls");
			if(currIcon=="icon-add"){
				create();
			}else if(currIcon=="icon-edit"){
				edit();
			}else if(currIcon=="icon-remove"){
				remove();
			}
		});
	});
	
	$('#btn_select').click(function() {
		var selected = $("#select_menu").tree("getSelected");
		if(valueIsNotEmpty(selected)){
			console.info(selected);
			$("#dialog").dialog("close");
		}else{
			$.messager.show({
				title : '提示信息：',
				msg : "请先选择一个父菜单"
			});
		}
	});
	
	$('#submit').click(function() {
		$.ajax({
			type : $method,
			data : $("#form").serialize(),
			url : $url,
//			提交前的操作，在这个方法内可以对表单进行验证（前台验证），如果返回为false，则该请求不会送到后台
			beforeSend:function(){
				console.info($("#form").serialize()+$("#form").form("validate"));
				return $("#form").form("validate");
//				return false;
		    },
			success : function(result) {
				try {
					if (result.success) {
//						以下代码清空所有操作
						$("#menu_tree").tree("reload");
						loadMenu();
						alert("操作成功");
						create();
					}
				} catch (e) {
					$.messager.show({
						title : '提示信息：',
						msg : "操作失败！" + e
					});
				}
			},
//			如果请求失败，服务器端报错500时执行该方法
			error : function(result) {
				$.messager.show({
					title : '提示信息：',
					msg : result.msg+";[type:"+$method+";data:"+$("#form").serialize()+";url:"+$url+"]"
				});
			}
		});
	});
});