/**
 * 全局变量$${classname}和$method
 * 这两个变量是为了让create和edit的方法公用的变量，目的是为了让
 * 增加和编辑方法公用同一个$("#submit")方法
 */
var $url;
var $method = "POST";

/**
 * 点击增加按钮的时候打开白哦单的对话框
 */
function create(){
//	初始化表单，将表单清空
	$('#form').form('clear');
//	$("#del_flag").val("0");
//	如jsp中的注释，创建一条记录的时候，自增id是不能传到后台的。默认会传空值，会报错。
	$('#increment_id').attr("disabled","disabled");
	$url = contextPath + "/save${classname}.do";
	$method = "POST";
}

function edit(){
//	初始化表单，清空所有组件的value值。
	$('#form').form('clear');
//	update记录的时候主键id必须传到后台，否则Hibernate更新操作的时候缺少where 主键="前台提交的值"的条件
	$('#increment_id').attr("disabled",false);
//	设置全局变量$url，指定编辑的时候调用后台的update${classname}的方法@RequestMapping(value="/update${classname}",method=RequestMethod.POST)
	$url = contextPath+"/update${classname}.do";
    $method = "POST";
    form._method.value="POST";
}

function remove(){
//	删除的时候先判断${functionName}是否有选中记录，多选的时候，getSelected方法直选中第一个选中的记录
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
//				指定删除操作调用后台的delete${classname}s的方法@RequestMapping(value="/delete${classname}s",method=RequestMethod.DELETE)
				$url = contextPath + "/delete${classname}s.do";
				$method = "POST";
				form._method.value = "DELETE";
//				调用getSelections的方法来对jsp中div的id为ids的标签插入所有选中记录的主键id
				getSelections();
				$('#form').form('load', row);
//				由于删除的时候只是一个confirm框，所以点击确定的时候触发的不是按钮submit的事件，因此需要通过jQuery的方法来触发按钮submit的点击事件。
//				该click事件会调用$('#submit').click(function() {  });的方法,该方法必须写在$(function(){})内部;
				$('#submit').click();
			}
		});
	} else {
		$.messager.alert('提示信息：', '请选择!', 'warning');
	}
}

function getSelections() {
	var rows = $('#datagrid').datagrid('getSelections');
	for ( var i = 0; i < rows.length; i++) {
		/**
		 * 删除事调用getSelections的方法，jQuery的append方法可以在document对象中插入html字符串
		 * 此例中是在id为ids的div下插入了隐藏的文本框，文本框的value值为选中的记录的主键id。如果该类的主键不是id
		 * 则应该将下面的rows[i].id改为rows[i].你设定的主键的值
		 */
		$("#ids").append(
				"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].id
						+ "\">");
	}
}

$(function(){
	
	$(".easyui-textbox").textbox({
		width : 200
	});
	
	/**
	 * easyui的layout布局的中部布局中有一个id为datagrid的table
	 * 通过本方法对datagrid进行初始化
	 */
	$('#datagrid').datagrid({
		
		iconCls : 'icon-save',//datagrid的图标
		nowrap : false,//单元格的字符串长于单元格的宽度时是否换行，默认是true不换行
		striped : true,//加条纹，默认是false
		fitColumns : true,//自适应列宽
		loadMsg:"正在努力加载数据，请稍后...",//载入数据时显示的提示消息
		url :  contextPath+'/list${classname}s.do',//载入数据的后台方法，后台返回的数据必须放在rows变量中。datagrid才能自动识别它。
		method : "POST",//请求方式
		pageSize : 20,
		pageList : [10,20,30,40,50,100],
		queryParams:{}, //查询条件
		fit : true,//整个表格是否自适应页面
		border : false,//是否有边框
		singleSelect:false,//datagrid是否只能单选
		idField : 'id',//主键

		columns : [ [
//			datagrid第一类为checkbox 
			{field:'ck',checkbox:true,align : 'center'},
			/**
			 * datagrid第二列,field的为User类中的成员变量的时候，datagrid会自动将值取出
			 * title为该列显示的表头
			 * align设置了居中显示
			 * width为设定宽度
			 */
			<#list fields as fld>
			{
				field : '${fld.field_name}',
				title : '${fld.field_comment}',
				align : 'center',
				width : 35
			}<#if fld_has_next>, </#if>
			</#list>
			 ] ],
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
				create();
//				每次载入玩后将datagrid初始化，清除所有选中行
				$('#datagrid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			},
			onClickRow : function(rowIndex, rowData){
//				console.info(rowData);
				edit();
				$("#form").form("load",rowData);
			}
		});
	
	/* 给linkbutton绑定操作； */
//	循环便利所有class为easyui-linkbutton的按钮
	$(".easyui-linkbutton").each(function(){
//		为当前按钮绑定点击事件
		$(this).unbind('click').bind('click', function(){
//			获取当前按钮的iconCls的值，根据值来判断点击了什么按钮
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
		$.ajax({
			type : $method,
			data : $("#form").serialize(),
			url : $url,
//			提交前的操作，在这个方法内可以对表单进行验证（前台验证），如果返回为false，则该请求不会送到后台
			beforeSend:function(){   
		        return $("#form").form('validate');   
		    },
			success : function(result) {
				try {
					if (result.success) {
//						以下代码清空所有操作
						$('#dialog').dialog('close');
						$('#datagrid').datagrid('reload');
						create();
						$("#ids").empty();
						alert("您的操作成功");
					} else {
						$.messager.show({
							title : '提示信息：',
							msg : result.msg+";[type:"+$method+";data:"+$("#form").serialize()+";url:"+$url+"]"
						});
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