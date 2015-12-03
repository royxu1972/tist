function login(){
	$.ajax({
		type : "POST",
		url : contextPath + '/login.do',//LoginController中
		data : $('#login_form').serializeArray(),
		cache : false,
		dataType : 'json',
		beforeSend: function(){
			var user_name = $("#user_name").val();
			var user_password = $("#user_password").val();
			if(valueIsNotEmpty(user_name)&&valueIsNotEmpty(user_password)){
				return true;
			}else{
				bootbox.alert("用户名或密码不能为空","确定");
				return false;
			}
			
		},
		success : function(r) {
			if(r.success){
				window.location.href= contextPath+"/afterroleselect.do";
			}else{
				bootbox.alert("对不起，您的账号或密码不正确，请重新登陆。","确定");
			}
		}
	});
}

$(function(){
	$("#btn_login").click(function(e){
		e.preventDefault();
		login();
	});
//	
//	$("#btn_regin").click(function(e){
//		e.preventDefault();
//		window.location.href= contextPath+"/shishanghui/regin/regin.jsp";
//	});
	
});

//$(document).keypress(function(e) {
//	switch (e.which) {
//	// user presses the "Enter"    
//	case 13:
////		alert("回车");
//		login();
//		break;
//	}
//}); 