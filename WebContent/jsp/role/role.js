var $url;
var $method = "POST";

/**
 * 点击增加按钮的时候打开白哦单的对话框
 */
function create(){
	$("#submit_text").text("新增角色");
//	初始化表单，将表单清空
	$('#form').form('clear');
//	如jsp中的注释，创建一条记录的时候，自增id是不能传到后台的。默认会传空值，会报错。
	$('#increment_id').attr("disabled","disabled");
	$url = contextPath + "/saverole2.do";
	$method = "POST";
	clearAllChecked();
}

function edit(){
	$("#submit_text").text("修改");
	$('#form').form('clear');
	$('#increment_id').attr("disabled",false);
	$url = contextPath+"/updaterole2.do";
    $method = "POST";
    form._method.value="POST";
}

function remove(){
//	删除的时候先判断角色是否有选中记录，多选的时候，getSelected方法直选中第一个选中的记录
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
				$('#increment_id').attr("disabled",false);
//				指定删除操作调用后台的deleteroles的方法@RequestMapping(value="/deleteroles",method=RequestMethod.DELETE)
				$url = contextPath + "/deleteroles.do";
				$method = "POST";
				form._method.value = "DELETE";
//				调用getSelections的方法来对jsp中div的id为ids的标签插入所有选中记录的主键id
				$('#form').form('load', row);
				clearAllChecked();
				$("#form").form("load",row);
				if(valueIsNotEmpty(row.menu_ids)){
					var array_ids = row.menu_ids.split(",");
					for(var i=0;i<array_ids.length;i++){
						if(array_ids[i].length>=3){//menu_id长度大于3的选中
							var node = $("#menu_tree").tree("find",array_ids[i]);
							$("#menu_tree").tree("check",node.target);
						}
					}
				}
//				由于删除的时候只是一个confirm框，所以点击确定的时候触发的不是按钮submit的事件，因此需要通过jQuery的方法来触发按钮submit的点击事件。
//				该click事件会调用$('#submit').click(function() {  });的方法,该方法必须写在$(function(){})内部;
				$('#submit').click();
			}
		});
	} else {
		$.messager.alert('提示信息：', '请选择要删除的角色', 'warning');
	}
}

function loadMenuTree(){
	$('#menu_tree').tree({
		animate: true, 
		url:  contextPath +'/menutree.do',
		lines : true,
		checkbox : true,
		cascadeCheck : true,
		async : false,
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
		}
	});
}

function clearAllChecked(){
	//清空所有tree的选项
	var root = $("#menu_tree").tree("getRoot");
//	console.info(root);
//	console.info(root.target);
	$("#menu_tree").tree("uncheck",root.target);
}

function clearForm(){
	create();
	$("#datagrid").datagrid("clearSelections");
	
}

function firstInit(){
	$("#submit_text").text("新增角色");
//	初始化表单，将表单清空
	$('#form').form('clear');
//	如jsp中的注释，创建一条记录的时候，自增id是不能传到后台的。默认会传空值，会报错。
	$('#increment_id').attr("disabled","disabled");
	$url = contextPath + "/saverole2.do";
	$method = "POST";
}

$(function(){
	
	$(".easyui-textbox").textbox({
		width : 200
	});
	
	loadMenuTree();
	
	$('#datagrid').datagrid({
		
		iconCls : 'icon-save',//datagrid的图标
		nowrap : false,//单元格的字符串长于单元格的宽度时是否换行，默认是true不换行
		striped : true,//加条纹，默认是false
		fitColumns : true,//自适应列宽
		loadMsg:"正在努力加载数据，请稍后...",//载入数据时显示的提示消息
		url :  contextPath+'/listroles.do',//载入数据的后台方法，后台返回的数据必须放在rows变量中。datagrid才能自动识别它。
		method : "POST",//请求方式
		pageSize : 100,
		pageList : [10,20,30,40,50,100],
		queryParams:{}, //查询条件
		fit : true,//整个表格是否自适应页面
		border : false,//是否有边框
		singleSelect:true,//datagrid是否只能单选
		idField : 'role_id',//主键

		columns : [ [
//			datagrid第一类为checkbox 
			{field:'ck',checkbox:true,align : 'center'},
			{
				field : 'role_name',
				title : '角色名称',
				align : 'center',
				width : 35
			}, {
				field : 'update_by',
				title : '最后修改人',
				align : 'center',
				width : 35
			}, {
				field : 'update_time',
				title : '最后修改时间',
				align : 'center',
				width : 35
			}, {
				field : 'note',
				title : '备注',
				align : 'center',
				width : 35
			}  ] ],
//			是否分页
			pagination : true,
//			是否显示每行的数字
			rownumbers : true,
			/**
			 * datagrid载入成功后执行的方法
			 * result中拥有后台传入的所有变量，本例中
			 * result包含有total,rows,success
			 * 下面是后台返回的内容
			 * mav.addObject("total", pageData.getTotalCount());
			 * mav.addObject("rows", pageData.getData());
			 * mav.addObject("success",true);
			 */
			onLoadSuccess : function(result) {
				/**
				 * 根据后台返回的total总量来提示当期是否有记录。
				 */
				if(result.total==0){
					$.messager.alert('查询结果','查询结束，未查找到相关数据。'); 
				}else{
					
				}
//				create();
				//datagrid加载完后，tree可能未加载完，如果直接调用create方法中的clearAllChecked方法可能获取到null的root，就会造成js错误
				firstInit();
//				每次载入玩后将datagrid初始化，清除所有选中行
				$('#datagrid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			},
			onClickRow : function(rowIndex, rowData){
//				console.info(rowData);
				edit();
				clearAllChecked();
				$("#form").form("load",rowData);
				if(valueIsNotEmpty(rowData.menu_ids)){
					var array_ids = rowData.menu_ids.split(",");
					for(var i=0;i<array_ids.length;i++){
						var node = $("#menu_tree").tree("find",array_ids[i]);
						var isLeaf = $("#menu_tree").tree("isLeaf",node.target);
						if(isLeaf){//判断该节点是否为叶子节点，是则勾选，否则不勾选（否则造成全选）
							$("#menu_tree").tree("check",node.target);
						}else{
//							console.info("非子节点不能勾选");
						}
					}
				}
			}
		});
	
	
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
	
	$('#submit').click(function() {
		//获取tree中选中的值
		var checked_nodes = $('#menu_tree').tree('getChecked',['checked','indeterminate']);
		var menu_ids = '';
	    for(var i=0; i<checked_nodes.length; i++){
	        if (menu_ids != '') menu_ids += ',';
	        menu_ids += checked_nodes[i].id;
	    }
		$("#menu_ids").val(menu_ids);
		
		$.ajax({
			type : $method,
			data : $("#form").serialize(),
			url : $url,
//			提交前的操作，在这个方法内可以对表单进行验证（前台验证），如果返回为false，则该请求不会送到后台
			beforeSend:function(){
				var role_name = $("#role_name").textbox("getValue");
				if(checked_nodes.length==0||valueIsEmpty(role_name)){
					if(checked_nodes.length==0){
						$.messager.show({
							title : '提示信息：',
							msg : "角色名称不能为空"
						});
						return false;
					}
					if(valueIsEmpty(role_name)){
						$.messager.show({
							title : '提示信息：',
							msg : "角色名称不能为空"
						});
					}
				}
				return $("#form").form("validate");
		    },
			success : function(result) {
				try {
					if (result.success) {
//						以下代码清空所有操作
						$("#form").form("clear");
						create();
						clearAllChecked();
						$("#datagrid").datagrid("reload");
						alert("操作成功");
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