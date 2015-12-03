var method;
var url;

function create(){
	//禁用自增id，不传回后台
	$('#increment_id').attr("disabled","disabled");
	//设置对话框标题
	$("#dialog_title").text("新增收货地址");
	//打开对话框
	$('#dialog').modal('show');
	//easyui清空表单的操作
	$("#data_form").form("clear");
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
	url = contextPath + "/saveuser.do";
	method = "POST";
	data_form._method.value="POST";
	$("#inputUser_id").val("1");
}

function edit(){
	$("#data_form").form("clear");
	$("#dialog_title").text("编辑收货地址");
	var rows = $('#data_table').bootstrapTable('getSelections');
	if(rows.length==1){
		$('#increment_id').attr("disabled",false);
		$("#data_form").form("load",rows[0]);
		$('#dialog').modal('show');
	}else{
		$.messager.alert('提示信息：', '请选择修改的记录！', 'warning');
	}
	url = contextPath+"/updateuser.do";
    method = "POST";
    data_form._method.value="POST";
}

function remove(){
	var rows = $('#data_table').bootstrapTable('getSelections');
	$("#data_form").form("clear");
	if(rows.length>0){
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
				url = contextPath + "/deleteusers.do";
				method = "POST";
				data_form._method.value="DELETE";
				for ( var i = 0; i < rows.length; i++) {
					$("#ids").append(
							"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].user_id
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
	    url: contextPath+'/listusers2.do',
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
	    idField: "increment_id",
	    columns: [{
	        field: 'state',
	        checkbox: true
	    }, {
	        field: 'user_name',
	        title: '用户名',
	        align: 'center',
	        sortable: true
	    }, {
	        field: 'user_password',
	        title: '密码',
	        align: 'center',
	        sortable: true,
	    }],
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
				validateForm();
		        return $("#data_form").valid();
		    },
			success : function(result) {
				try {
					if (result.success) {
//							以下代码清空所有操作
						$("#dialog").modal("hide");
						$('#data_table').bootstrapTable("refresh");
						$('#data_table').bootstrapTable("uncheckAll");
						$("#ids").empty();
						$("#data_form").form("clear");
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