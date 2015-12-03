<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<style type="text/css">
/**
 * Unicorn Admin Template
 * Diablo9983 -> diablo9983@gmail.com
**/
html, body {
    width: 100%;
    height: 100%;
    overflow:hidden;
}
body {
	background-color: #444444;
	background-image: -webkit-gradient(linear, 0 0%, 0 100%, from(#555555), to(#111111));
	background-image: -webkit-linear-gradient(top, #555555 0%, #111111 100%);
    background-image: -moz-linear-gradient(top, #555555 0%, #111111 100%);
    background-image: -ms-linear-gradient(top, #555555 0%, #111111 100%);
    background-image: -o-linear-gradient(top, #555555 0%, #111111 100%);
    background-image: linear-gradient(top, #555555 0%, #111111 100%);
    padding: 0;
    margin: 0;
}

.form-group label {
	color: #FFF;
}
</style>
<script type="text/javascript">
	var user_name = "";
	<% 
		String user_name = "";
		if(session.getAttribute("user_id") != null){
			user_name = session.getAttribute("user_id").toString();
		}
	%>
	user_name = '<%=user_name%>';
	if(valueIsNotEmpty(user_name)){
		window.location.href= contextPath+"/bjsp/basicinfo/basicinfo.jsp";
	}
</script>
<title>Royxu登陆</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid" style="margin-top:100px;">
			<div class="span3"></div>
			
			<div class="span6" style="border: 1px solid #DDD;border-radius: 0.55em;padding:10px;">
				<!-- 表单部分 -->
				<form class="form-horizontal" id="login_form">
				  <div class="form-group">
				    <label for="name" class="col-sm-4 control-label">用户名：</label>
				    <div class="col-sm-6">
				      <input type="text" class="form-control" id="user_name" name="login_name" placeholder="管理员账号">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="gender" class="col-sm-4 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				    <div class="col-sm-6">
				      <input type="password" class="form-control" id="user_password" name="user_password" placeholder="管理员密码">
				    </div>
				  </div>
				  
				</form>
				
				  <div class="form-group">
				    <div class="col-sm-offset-4 col-sm-6">
				        <button type="button" class="btn btn-warning btn-block" id="btn_login">
				        	<i class="glyphicon glyphicon-ok"></i>&nbsp;登&nbsp;录
				        </button>
				    </div>
				  </div>
			</div>
			
			<div class="span3"></div>
		</div>
	</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/login/login.js"></script>
</body>
</html>

