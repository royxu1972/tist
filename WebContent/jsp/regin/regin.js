$(function(){
	$('#submit').click(function() {
		$.ajax({
			type : "POST",
			data : $("#form").serialize(),
			url : contextPath+'/regin.do',
			beforeSend:function(){
				var result = true;
		        var user_name = $("#user_name").val();  
		        var user_password = $("#user_password").val();
		        if(valueIsEmpty(user_name)){
		        	result = false;
		        	alert("用户名不能为空");
		        }
		        if(valueIsEmpty(user_password)){
		        	result = false;
		        	alert("密码不能为空");
		        }
		        return result;
		    },
			success : function(result) {
				try {
					if (result.success) {
						alert("注册成功");
						$("#form").form("clear");
					} else {
						$.messager.show({
							title : '提示信息：',
							msg : result.msg
						});
					}
				} catch (e) {
					$.messager.show({
						title : '提示信息：',
						msg : "操作失败！" + e
					});
				}
			},
			error : function(result) {
				$.messager.show({
					title : '提示信息：',
					msg : result.msg+";[type:"+$method+";data:"+$("#fm").serialize()+";url:"+$url+"]"
				});
			}
		});
	});
});