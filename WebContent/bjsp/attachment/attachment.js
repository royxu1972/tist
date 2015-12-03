//全局变量
var method;
var url;

function create(){
	//禁用自增id，不传回后台
	$('#increment_id').attr("disabled","disabled");
	//设置对话框标题
	$("#dialog_title").text("新增附件");
	//打开对话框
	$('#dialog').modal('show');
	//easyui清空表单的操作
	$("#data_form").form("clear");
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
	//保存方法,在AttachmentController.java中
	url = contextPath + "/saveattachment.do";
	method = "POST";
	data_form._method.value="POST";
}

function edit(){
	//easyui清空表单的操作
	$("#data_form").form("clear");
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
	$("#dialog_title").text("编辑附件");
	var rows = $('#data_table').bootstrapTable('getSelections');
	if(rows.length==1){
		//解除自增id的禁用，传回后台
		$('#increment_id').attr("disabled",false);
		//easyui载入选中行数据的方法
		$("#data_form").form("load",rows[0]);
		//显示bootstrap对话框
		$('#dialog').modal('show');
	}else{
		//easyui的警告框
		$.messager.alert('提示信息：', '请选择修改的记录！', 'warning');
	}
	//修改方法,在AttachmentController.java中
	url = contextPath+"/updateattachment.do";
    method = "POST";
    data_form._method.value="POST";
}

function remove(){
	//bootstraptable获取所有选中行的方法
	var rows = $('#data_table').bootstrapTable('getSelections');
	//easyui清空表单的操作
	$("#data_form").form("clear");
	if(rows.length>0){
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
				//删除方法,在AttachmentController.java中
				url = contextPath + "/deleteattachments.do";
				method = "POST";
				data_form._method.value="DELETE";
				for ( var i = 0; i < rows.length; i++) {
					$("#ids").append(
							"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].attachment_id
									+ "\">");
					}
				$('#data_form').form('load', rows[0]);
				$('#submit').click();
			}
		});
		
	}else{
		$.messager.alert('提示信息：', '请选择要删除的记录!', 'warning');
	}
}

$(function(){
	
	$('#data_table').bootstrapTable({
	    method: 'GET',
	    url: contextPath+'/listpagedattachments.do',//分页查询,在AttachmentController.java中
	    cache: false,
	    height: 450,
	    striped: true,
	    pagination: true,
	    sidePagination:'server',//分页必须加上是server分页还是client分页
	    pageSize: 10,
	    pageList: [10, 25, 50, 100, 200],
	    toolbarAlign: 'left',
	    searchAlign: 'right',
	    toolbar: '#table_toolbar',
	    showColumns: true,
	    showRefresh: true,
	    showToggle: true,
//	    smartDisplay: false,
	    minimumCountColumns: 2,
	    clickToSelect: true,
	    idField: "attachment_id",
	    columns: [
		    {
		        field: 'state',
		        checkbox: true
		    }, 
			{
				field : 'attachment_id',
				title : '附件主键id',
				align : 'center'
			}, 
			{
				field : 'table_of_attachment',
				title : '附件所属表',
				align : 'center'
			}, 
			{
				field : 'related_id',
				title : '附件关联id',
				align : 'center'
			}, 
			{
				field : 'original_name',
				title : '原文件名',
				align : 'center'
			}, 
			{
				field : 'new_name',
				title : '新文件名',
				align : 'center'
			}, 
			{
				field : 'file_type',
				title : '文件类型',
				align : 'center'
			}, 
			{
				field : 'file_path',
				title : '文件路径',
				align : 'center'
			}, 
			{
				field : 'del_flag',
				title : '删除标志位',
				align : 'center'
			}
	    
	    ],
	    onLoadSuccess: function(data){
	    	$('#data_table').bootstrapTable("uncheckAll");
	    }
	});
	
	$(".tool_buttons").each(function(){
//		为当前按钮绑定点击事件
		$(this).unbind('click').bind('click', function(){
//			获取当前按钮的iconCls的值，根据值来判断用户点击了什么按钮
			var btn_id=$(this).attr("id");
			if(btn_id=="create"){
				create();
			}else if(btn_id=="edit"){
				edit();
			}else if(btn_id=="remove"){
				remove();
			}
		});
	});
	
	$('#submit').click(function() {
		$.ajax({
			type : "POST",
			data : $("#data_form").serialize(),
			url : url,
			beforeSend:function(){
				validateForm();//在attachment_validate.js中
		        return $("#data_form").valid();
		    },
			success : function(result) {
				try {
					if (result.success) {
//							以下代码清空所有操作
						$("#dialog").modal("hide");
						//重载bootstraptable
						$('#data_table').bootstrapTable("refresh");
						$('#data_table').bootstrapTable("uncheckAll");
						//清空ids中的所有元素
						$("#ids").empty();
						//easyui清空表单
						$("#data_form").form("clear");
						//清空验证状态(于public/js/public.js中)
						removeValidate("#data_form");
						$.messager.show({
							title : '提示信息：',
							msg : "操作成功!"
						});
					}
				} catch (e) {
					$.messager.show({
						title : '提示信息：',
						msg : "操作失败！" + e
					});
				}
			},
//				如果请求失败，服务器端报错500时执行该方法
			error : function(result) {
				$.messager.show({
					title : '提示信息：',
					msg : result.msg+";[type:"+method+";data:"+$("#data_form").serialize()+";url:"+url+"]"
				});
			}
		});
	});
});