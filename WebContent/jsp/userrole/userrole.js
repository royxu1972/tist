var $url;
var $method = "POST";
var json_roles;

/**
 * 点击增加按钮的时候打开白哦单的对话框
 */
function create(){
//	初始化表单，将表单清空
	$('#form').form('clear');
//	如jsp中的注释，创建一条记录的时候，自增id是不能传到后台的。默认会传空值，会报错。
	$('#increment_id').attr("disabled","disabled");
	$url = contextPath + "/saveuserrole.do";
	$method = "POST";
	
}

function edit(){
	$('#form').form('clear');
	$('#increment_id').attr("disabled",false);
	$url = contextPath+"/updateuserrole.do";
    $method = "POST";
    form._method.value="POST";
}

function remove(){
//	删除的时候先判断角色是否有选中记录，多选的时候，getSelected方法直选中第一个选中的记录
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		if(valueIsNotEmpty(row.increment_id)){
			$.messager.confirm('Confirm', '确定要删除?', function(r) {
				if (r) {
					$('#increment_id').attr("disabled",false);
//					指定删除操作调用后台的deleteuserroles的方法@RequestMapping(value="/deleteuserroles",method=RequestMethod.DELETE)
					$url = contextPath + "/deleteuserrole.do";
					$method = "POST";
					form._method.value = "DELETE";
//					调用getSelections的方法来对jsp中div的id为ids的标签插入所有选中记录的主键id
					$('#form').form('load', row);
//					由于删除的时候只是一个confirm框，所以点击确定的时候触发的不是按钮submit的事件，因此需要通过jQuery的方法来触发按钮submit的点击事件。
//					该click事件会调用$('#submit').click(function() {  });的方法,该方法必须写在$(function(){})内部;
					$('#submit').click();
				}
			});
		}else{
			$.messager.alert('提示信息：', '改用户未被分配角色', 'warning');
		}
		
	} else {
		$.messager.alert('提示信息：', '请选择!', 'warning');
	}
}

function loadRoles(){
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/listallroles.do',
        dataType: 'json',
        async : false,
        success: function(result) {
        	json_roles = result.rows;
        	var tr_idx = 0;
        	$.each(result.rows,function(idx,item){
        		
        		if(idx%4 == 0){
        			tr_idx = idx+1;
        			$("#role_checkbox").append("<tr id='tr_"+tr_idx+"'>");
//        			console.info("<tr id='tr"+idx+"'>");
        		}
        		var html = "<td><input type='checkbox' id='ck"+item.role_id+"' value='"+item.role_id+"' />&nbsp;&nbsp;" +
        					"<label for='ck"+item.role_id+"'>"+item.role_name+"</label></td>";
//        		console.info(html);
        		$("#tr_"+tr_idx).append(html);
        		if((idx+1)%4 == 0){
        			$("#role_checkbox").append("</tr>");
//        			console.info("</tr>");
        		}
			});
        	var rest_num = result.rows.length%4;
			if(rest_num != 0){
				for(var i=0;i<(4-rest_num);i++){
					$("#tr_"+tr_idx).append("<td>&nbsp;</td>");
				}
				$("#role_checkbox").append("</tr>");
			}
        }
    });
}

$(function(){
	
	loadRoles();
	
	$('#datagrid').datagrid({
		
		iconCls : 'icon-save',//datagrid的图标
		nowrap : false,//单元格的字符串长于单元格的宽度时是否换行，默认是true不换行
		striped : true,//加条纹，默认是false
		fitColumns : true,//自适应列宽
		loadMsg:"正在努力加载数据，请稍后...",//载入数据时显示的提示消息
		url :  contextPath+'/listusers.do',//载入数据的后台方法，后台返回的数据必须放在rows变量中。datagrid才能自动识别它。
		method : "POST",//请求方式
		pageSize : 20,
		pageList : [10,20,30,40,50,100],
		queryParams:{}, //查询条件
		fit : true,//整个表格是否自适应页面
		border : false,//是否有边框
		singleSelect:true,//datagrid是否只能单选
		idField : 'increment_id',//主键

		columns : [ [
//			datagrid第一类为checkbox 
			{field:'ck',checkbox:true,align : 'center'},
			{
				field : 'user_name',
				title : '用户名',
				align : 'center',
				width : 35
			}, {
				field : 'role_ids',
				title : '拥有的角色',
				align : 'center',
				width : 35,
				formatter : function(value, rowData, rowIndex){
					if(valueIsEmpty(value)){
						return "暂未分配角色";
					}else{
						var role_names = "";
						if(value.indexOf(",")>0){
							var values = value.split(",");
							for(var i=0;i<values.length;i++){
								for(var j=0;j<json_roles.length;j++){
									if(values[i] == json_roles[j].role_id){
//										console.info(json_roles[j].role_name);
										if(role_names != '') role_names += ",";
										role_names += json_roles[j].role_name;
									}
								}
							}
						}else{
							for(var j=0;j<json_roles.length;j++){
								if(value == json_roles[j].role_id){
									role_names += json_roles[j].role_name;
								}
							}
						}
						
						return role_names;
					}
				}
			}  ] ],
//			是否分页
			pagination : true,
//			是否显示每行的数字
			rownumbers : true,
			onLoadSuccess : function(result) {
				/**
				 * 根据后台返回的total总量来提示当期是否有记录。
				 */
				if(result.total==0){
					$.messager.alert('查询结果','查询结束，未查找到相关数据。'); 
				}else{
					
				}
				create();
//				每次载入玩后将datagrid初始化，清除所有选中行
				$('#datagrid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			},
			onClickRow : function(rowIndex, rowData){
//				console.info(rowData);
				if(valueIsEmpty(rowData.increment_id)){//如果该角色在sys_user_role表中没有有increment_id，说明未分配角色
					create();
					$("#form").form("load",rowData);
				}else{//否则只做更新操作
					edit();
					$("#form").form("load",rowData);
					if(valueIsNotEmpty(rowData.role_ids)){
						var role_ids=rowData.role_ids.split(",");
						//外层循环便利station表中已有的服务形式
						for(var i=0;i<role_ids.length;i++){
							var role_ids_i = role_ids[i];
							//内层循环便利数据字典中所有的服务形式group_service_type
							for(var j=0;j<json_roles.length;j++){
								if(role_ids_i == json_roles[j].role_id){
									//将每个服务形式后面加上分号，因为checkbox中所有的value最后都有分号
									var role_id_temp = json_roles[j].role_id;
									$("#role_checkbox input[type=checkbox][value='"+role_id_temp+"']").prop("checked", true);
								}
							}
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
		var checked=$("#role_checkbox input[type='checkbox']:checked").val([]); 
		var checked_value = ""; 
		//查看选中的服务类型
		for(var i=0;i<checked.length;i++){
			if (checked_value != '') checked_value += ',';
			checked_value += checked[i].value; 
		}
		$("#role_ids").val(checked_value);
		$.ajax({
			type : $method,
			data : $("#form").serialize(),
			url : $url,
//			提交前的操作，在这个方法内可以对表单进行验证（前台验证），如果返回为false，则该请求不会送到后台
			beforeSend:function(){
				console.info($url+"\t"+$("#role_ids").val());
				console.info($("#form").serialize());
				if(checked.length == 0){
					$.messager.show({
						title : '提示信息：',
						msg : "请至少选择一个角色"
					});
					return false;
				}else{
					return true;
				}
				
		    },
			success : function(result) {
				try {
					if (result.success) {
//						以下代码清空所有操作
						$("#form").form("clear");
						create();
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