function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
			"user_password" : {
				required : true,
				remote : {
					type: "POST",
					url : contextPath + "/rightoldpassword.do",
					dataType: "json",
					async : false,//必须加上async，否则此处验证没完成也可以提交。
					data : {
						user_id : function(){
							var u_id = $("#increment_id").val();
							return u_id;
						},
						old_password : function(){
							var old_pass = $("#user_password").val();
							return old_pass;
						}
					}
				}
			}, 
			"login_name" : {
				required : true,
				remote : {
					type: "POST",
					url : contextPath + "/existloginname.do",
					dataType: "json",
					async : false,//必须加上async，否则此处验证没完成也可以提交。
					data : {
						user_id : function(){
							var u_id = $("#increment_id").val();
							return u_id;
						},
						login_name : function(){
							var login_name = $("#login_name").val();
							return login_name;
						}
					}
				}
			}, 
			"new_pswd" : {
				required : true,
				rangelength:[6,30]
			}, 
			"renew_pswd" : {
				required : true,
				rangelength:[6,30]
			}
		},
	
		messages : {
			"user_password" : {
				required : "必填",
				remote : "原始密码错误"
			}, 
			"login_name" : {
				required : "必填",
				remote : "该用户名已被使用，请更换。"
			}, 
			"new_pswd" : {
				required : "必填",
				rangelength:"密码必须6-30位"
			}, 
			"renew_pswd" : {
				required : "必填",
				rangelength:"密码必须6-30位"
			}
		},
		
		validClass:"checked", 
		errorClass : "error",
		errorElement : "span",
		errorPlacement : function(error, element) {
			//给bootstrap表单中class为form-group的div增加has-error的样式，整行变红
			element.parent().parent().addClass("has-error");
		    //验证元素的后面追加如“必填”的验证提示
		    error.appendTo(element.parent());
		},  
		success: function(label) {
			//删除bootstrap表单中class为form-group的div的has-error，恢复成正常表单状态
			label.parent().parent().removeClass("has-error");
			//删除验证元素的后面追加的如“必填”的验证提示
			label.remove();
        }
	});
}