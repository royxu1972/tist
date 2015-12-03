<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/bootbox3.3.0.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/login/unicorn.login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/login/login.js"></script>
<title>管理员登陆</title>
</head>

<body>
	<div id="logo">
         <img src="${pageContext.request.contextPath}/jsp/login/logo.png" alt="" />
     </div>
     <div id="loginbox">            
         <form id="login_form" class="form-vertical">
			 <p>请输入用户名和密码</p>
             <div class="control-group">
                 <div class="controls">
                     <div class="input-prepend">
                         <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="用户名" id="user_name" name="login_name" />
                     </div>
                 </div>
             </div>
             <div class="control-group">
                 <div class="controls">
                     <div class="input-prepend">
                         <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="密码" id="user_password" name="user_password" />
                     </div>
                 </div>
             </div>
             <div class="form-actions">
                 <span class="pull-left"><a href="#" class="flip-link" id="to-recover">忘记密码?</a></span>
                 <span class="pull-right"><button id="btn_login" class="btn btn-primary">登陆</button></span>
             </div>
         </form>
     </div>
</body>
</html>
