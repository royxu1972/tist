//全局变量
var method;
var url = contextPath + "/updatepassword.do";
var right_password = false;

function loadBasicinfos(){
	$("#data_form").form("clear");
	
	$.ajax({
        type: "POST",
        url: contextPath + '/finduserbysession.do',
        async : false,
        success: function(result) {
//        	console.info(result);
        	if(result.success){
        		if(valueIsNotEmpty(result.user)){
        			$("#user_name").val(result.user.user_name);
        			$("#user_no").val(result.user.user_no);
        			$("#login_name").val(result.user.login_name);
        			$("#increment_id").val(result.user.user_id);
        			$("#del_flag").val(result.user.del_flag);
            	}else{
            		$.messager.alert('提示信息：', "对不起，数据查询失败", 'warning');
            	}
        	}else{
        		$.messager.alert('提示信息：', result.msg, 'warning');
        		$("#data_form input").attr("disabled","disabled");
        		$("#data_form textarea").attr("disabled","disabled");
        	}
        	
        }
    });
}

$(function(){
	
	loadMyMenus();
	loadBasicinfos();
	
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
				validateForm();//在basicinfo_validate.js中
				if($("#new_pswd").val() != $("#renew_pswd").val()){
					$.messager.alert('提示信息：', "两次新密码不一致", 'warning');
					return false;
				}
		        return $("#data_form").valid();
		    },
			success : function(result) {
				try {
					if (result.success) {
//							以下代码清空所有操作
//						$("#dialog").modal("hide");
						//重载bootstraptable
//						$('#data_table').bootstrapTable("refresh");
//						$('#data_table').bootstrapTable("uncheckAll");
						//easyui清空表单
//						$("#data_form").form("clear");
						//清空验证状态(于public/js/public.js中)
						removeValidate("#data_form");
						$.messager.show({
							title : '提示信息：',
							msg : "密码修改成功!"
						});
						//清空ids中的所有元素
						$("#ids").empty();
						loadBasicinfos();
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