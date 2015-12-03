/**
 * 全局变量$systemdictionarytype和$method
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
	$("#del_flag").val("0");
//	easyui的dialog提供的方法，此处是先执行open方法，然后对本对话框设置标题
	$('#dialog').dialog('open').dialog('setTitle', '创建数据字典类型');
//	如jsp中的注释，创建一条记录的时候，自增id是不能传到后台的。默认会传空值，会报错。
	$('#increment_id').attr("disabled","disabled");
	$url = contextPath + "/savesystemdictionarytype.do";
	$method = "POST";
}

function edit(){
//	easyui中获取datagrid中的选中行
	var row = $('#datagrid').datagrid('getSelected');
//	easyui中获取datagrid中选中的多行记录
	var rows = $('#datagrid').datagrid('getSelections');
//	判断消息发布选中的是单行还是多行，编辑的时候只能选中单行，多行的时候只能修改第一个选中的记录
	if(rows.length!=1){
		$.messager.alert('提示信息：', '请只选择一条记录进行修改！', 'warning');
	}else{
//		如果改行有记录则执行以下方法
		if (row) {
//			初始化表单，清空所有组件的value值。
			$('#form').form('clear');
//			update记录的时候主键id必须传到后台，否则Hibernate更新操作的时候缺少where 主键="前台提交的值"的条件
			$('#increment_id').attr("disabled",false);
//			easyui提供的表单的方法，将选中行的所有数据载入到表单中。
			$('#form').form('load', row);
//			easyui的打开dialog的方法，并且设置新标题
			$('#dialog').dialog('open').dialog('setTitle', '编辑数据字典');
		} else {
			$.messager.alert('提示信息：', '请选择修改的记录！', 'warning');
		}
//		设置全局变量$url，指定编辑的时候调用后台的updatesystemdictionarytype的方法@RequestMapping(value="/updatesystemdictionarytype",method=RequestMethod.POST)
		$url = contextPath+"/updatesystemdictionarytype.do";
	    $method = "POST";
	}
}

function remove(){
//	删除的时候先判断数据字典类型管理是否有选中记录，多选的时候，getSelected方法直选中第一个选中的记录
	var row = $('#datagrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
//				指定删除操作调用后台的deletesystemdictionarytypes的方法@RequestMapping(value="/deletesystemdictionarytypes",method=RequestMethod.DELETE)
				$url = contextPath + "/deletesystemdictionarytype.do";
				$method = "POST";
//				update记录的时候主键id必须传到后台，否则Hibernate更新操作的时候缺少where 主键="前台提交的值"的条件
				$('#increment_id').attr("disabled",false);
//				调用getSelections的方法来对jsp中div的id为ids的标签插入所有选中记录的主键id
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
				"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].increment_id
						+ "\">");
	}
}

///////////////////////////////////////////create2 edit2 remove2///////////////////////////////////////////////////////
/**
 * 点击增加按钮的时候打开白哦单的对话框
 */
function create2(){
//	初始化表单，将表单清空
	$('#form2').form('clear');
	$("#del_flag2").val("0");
//	获取父项id，左边datagrid中选中行的increment_id
	var row = $('#datagrid').datagrid('getSelected');
	if(row){
//		easyui的dialog提供的方法，此处是先执行open方法，然后对本对话框设置标题
		$('#dialog2').dialog('open').dialog('setTitle', '创建数据字典管理');
		$("#father_id").textbox("setValue",row.increment_id);
//		如jsp中的注释，创建一条记录的时候，自增id是不能传到后台的。默认会传空值，会报错。
		$('#increment_id2').attr("disabled","disabled");
		$url = contextPath + "/savesystemdictionary.do";
		$method = "POST";
	}else{
		$.messager.alert('提示信息：', '请先选中左侧表格中的某行数据', 'warning');
	}
}

function edit2(){
//	easyui中获取datagrid中的选中行
	var row = $('#datagrid2').datagrid('getSelected');
//	easyui中获取datagrid中选中的多行记录
	var rows = $('#datagrid2').datagrid('getSelections');
//	判断数据字典管理选中的是单行还是多行，编辑的时候只能选中单行，多行的时候只能修改第一个选中的记录
	if(rows.length!=1){
		$.messager.alert('提示信息：', '请只选择一条记录进行修改！', 'warning');
	}else{
//		如果改行有记录则执行以下方法
		if (row) {
//			easyui的打开dialog的方法，并且设置新标题
			$('#dialog2').dialog('open').dialog('setTitle', '编辑数据字典管理');
//			初始化表单，清空所有组件的value值。
			$('#form2').form('clear');
//			update记录的时候主键id必须传到后台，否则Hibernate更新操作的时候缺少where 主键="前台提交的值"的条件
			$('#increment_id2').attr("disabled",false);
//			easyui提供的表单的方法，将选中行的所有数据载入到表单中。
			$('#form2').form('load', row);
		} else {
			$.messager.alert('提示信息：', '请选择修改的记录！', 'warning');
		}
//		设置全局变量$url，指定编辑的时候调用后台的updatesystemdictionary的方法@RequestMapping(value="/updatesystemdictionary",method=RequestMethod.POST)
		$url = contextPath+"/updatesystemdictionary.do";
	    $method = "POST";
	}
}

function remove2(){
//	删除的时候先判断数据字典管理是否有选中记录，多选的时候，getSelected方法直选中第一个选中的记录
	var row = $('#datagrid2').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
//				指定删除操作调用后台的deletesystemdictionarys的方法@RequestMapping(value="/deletesystemdictionarys",method=RequestMethod.DELETE)
				$url = contextPath + "/deletesystemdictionarys.do";
				$method = "POST";
//				调用getSelections的方法来对jsp中div的id为ids的标签插入所有选中记录的主键id
				getSelections2();
				$('#form2').form('load', row);
//				由于删除的时候只是一个confirm框，所以点击确定的时候触发的不是按钮submit的事件，因此需要通过jQuery的方法来触发按钮submit的点击事件。
//				该click事件会调用$('#submit2').click(function() {  });的方法,该方法必须写在$(function(){})内部;
				$('#submit2').click();
			}
		});
	} else {
		$.messager.alert('提示信息：', '请选择!', 'warning');
	}
}

function getSelections2() {
	var rows = $('#datagrid2').datagrid('getSelections');
	for ( var i = 0; i < rows.length; i++) {
		/**
		 * 删除事调用getSelections的方法，jQuery的append方法可以在document对象中插入html字符串
		 * 此例中是在id为ids的div下插入了隐藏的文本框，文本框的value值为选中的记录的主键id。如果该类的主键不是id
		 * 则应该将下面的rows[i].id改为rows[i].你设定的主键的值
		 */
		$("#ids2").append(
				"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].increment_id
						+ "\">");
	}
}

function loadDict(father_id){//搜索
	var params = $('#datagrid2').datagrid('options').queryParams; //先取得 datagrid 的查询参数
	params['father_id'] = father_id; //设置查询参数
	$('#datagrid2').datagrid('reload'); //设置好查询参数 reload 一下就可以了
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
		url :  contextPath+'/listsystemdictionarytypes.do',//载入数据的后台方法，后台返回的数据必须放在rows变量中。datagrid才能自动识别它。
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
			/**
			 * datagrid第二列,field的为User类中的成员变量的时候，datagrid会自动将值取出
			 * title为该列显示的表头
			 * align设置了居中显示
			 * width为设定宽度
			 */
			{
				field : 'increment_id',
				title : '编码',
				align : 'center',
				width : 15
			},
			{
				field : 'dict_name',
				title : '数据字典名称',
				align : 'center',
				width : 40
			}, 
			{
				field : 'desciption',
				title : '描述',
				align : 'center',
				width : 50
			}
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
					$.messager.show({
						title : '提示信息：',
						msg : '查询结束，未查找到相关数据。'
					});
				}else{
					
				}
				/**
				 * 清空右侧datagrid的所有数据
				 */
				var params = $('#datagrid2').datagrid('options').queryParams; //先取得 datagrid 的查询参数
				params['father_id'] = ""; //设置查询参数
				$('#datagrid2').datagrid('loadData',{"total":"0","rows":[]});
//				每次载入玩后将datagrid初始化，清除所有选中行
				$('#datagrid').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			},
			onClickRow : function(rowIndex, rowData){
//				console.info(rowData);
//				edit();
//				$("#form").form("load",rowData);
				loadDict(rowData.increment_id);
			}
		});
	
	/**
	 * easyui的layout布局的中部布局中有一个id为datagrid的table
	 * 通过本方法对datagrid进行初始化
	 */
	$('#datagrid2').datagrid({
		
		iconCls : 'icon-save',//datagrid的图标
		nowrap : false,//单元格的字符串长于单元格的宽度时是否换行，默认是true不换行
		striped : true,//加条纹，默认是false
		fitColumns : true,//自适应列宽
		loadMsg:"正在努力加载数据，请稍后...",//载入数据时显示的提示消息
		url :  contextPath+'/listsystemdictionarysbyfatherid.do',//载入数据的后台方法，后台返回的数据必须放在rows变量中。datagrid才能自动识别它。
		method : "POST",//请求方式
		pageSize : 20,
		pageList : [10,20,30,40,50,100],
		queryParams:{father_id:""}, //查询条件
		fit : true,//整个表格是否自适应页面
		border : false,//是否有边框
		singleSelect:false,//datagrid是否只能单选
		idField : 'increment_id',//主键

		columns : [ [
//			datagrid第一类为checkbox 
			{field:'ck',checkbox:true,align : 'center'},
			/**
			 * datagrid第二列,field的为User类中的成员变量的时候，datagrid会自动将值取出
			 * title为该列显示的表头
			 * align设置了居中显示
			 * width为设定宽度
			 */
			{
				field : 'name',
				title : '名称',
				align : 'center',
				width : 35
			}, 
			{
				field : 'description',
				title : '描述',
				align : 'center',
				width : 35
			}, 
			{
				field : 'sort',
				title : '数据字典顺序',
				align : 'center',
				width : 35
			}
			 ] ],
//			是否分页
			pagination : true,
//			是否显示每行的数字
			rownumbers : true,
			onBeforeLoad : function(params){
				if(valueIsEmpty(params.father_id)){
					return false;
				}else{
					return true;
				}
			},
			onLoadSuccess : function(result) {
				/**
				 * 根据后台返回的total总量来提示当期是否有记录。
				 */
				var params = $('#datagrid2').datagrid('options').queryParams; //先取得 datagrid 的查询参数
				if(result.total==0&&valueIsNotEmpty(params['father_id'])){
					$.messager.show({
						title : '提示信息：',
						msg : '查询结束，未查找到相关数据。'
					});
				}else{
					
				}
//				每次载入玩后将datagrid初始化，清除所有选中行
				$('#datagrid2').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
	
	/* 给linkbutton绑定操作； */
//	循环便利所有class为easyui-linkbutton的按钮
	$(".easyui-linkbutton").each(function(){
//		为当前按钮绑定点击事件
		$(this).unbind('click').bind('click', function(){
//			获取当前按钮的iconCls的值，根据值来判断点击了什么按钮
			var currIcon=$(this).attr("id");
			if(currIcon=="add1"){
				create();
			}else if(currIcon=="edit1"){
				edit();
			}else if(currIcon=="remove1"){
				remove();
			}else if(currIcon=="add2"){
				create2();
			}else if(currIcon=="edit2"){
				edit2();
			}else if(currIcon=="remove2"){
				remove2();
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
	
	$('#submit2').click(function() {
		$.ajax({
			type : $method,
			data : $("#form2").serialize(),
			url : $url,
//			提交前的操作，在这个方法内可以对表单进行验证（前台验证），如果返回为false，则该请求不会送到后台
			beforeSend:function(){   
		        return $("#form2").form('validate');   
		    },
			success : function(result) {
				try {
					if (result.success) {
//						以下代码清空所有操作
						$('#dialog2').dialog('close');
						$('#datagrid2').datagrid('reload');
						$('#datagrid2').datagrid('clearSelections');
						$("#ids2").empty();
						alert("您的操作成功");
					} else {
						$.messager.show({
							title : '提示信息：',
							msg : result.msg+";[type:"+$method+";data:"+$("#form2").serialize()+";url:"+$url+"]"
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
					msg : result.msg+";[type:"+$method+";data:"+$("#form2").serialize()+";url:"+$url+"]"
				});
			}
		});
	});
	
});