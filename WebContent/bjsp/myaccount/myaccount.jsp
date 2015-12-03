<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<title>修改密码</title>
</head>
<body>
	<!-- 引入公共头部菜单 -->
	<jsp:include page="/public/jsp/head.jsp"></jsp:include>
	
	<!-- 页面主要部分 -->
	<div class="container-fluid" id="below-nav">
		<div class="container">
			<div class="jumbotron">
			
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<div>
								<font color="#08C"style="font-size:20px;font-family:微软雅黑;">修改密码</font>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 表单部分 -->
				<form class="form-horizontal" id="data_form">
				  <div class="form-group">
				    <label for="user_name" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="user_name" name="user_name" readonly="true">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="user_no" class="col-sm-2 control-label">您的编号</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="user_no" name="user_no" readonly="true">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="login_name" class="col-sm-2 control-label">设置登陆名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="login_name" name="login_name">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="user_password" class="col-sm-2 control-label">原始密码</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="user_password" name="user_password">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="new_pswd" class="col-sm-2 control-label">新密码</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="new_pswd" name="new_pswd">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="renew_pswd" class="col-sm-2 control-label">确认新密码</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="renew_pswd" name="renew_pswd">
				    </div>
				  </div>
			  
				  <!-- 删除时使用 -->
				  <div id="ids" type="hidden"></div>
				  <!-- 表单隐藏部分 -->
				  <div style="display:none;">
				  	<input id="increment_id" name="user_id">
				  	<input id="del_flag" name="del_flag">
				  	<input name="_method" value="post"/>
				  </div>
				  
				</form>
				
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				        <button type="button" class="btn btn-primary" id="submit">
				        	<i class="glyphicon glyphicon-ok"></i>&nbsp;修&nbsp;改
				        </button>
				    </div>
				  </div>
				
			</div>
		</div>
	</div>
		
<!-- 表单验证js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/myaccount/myaccount_validate.js"></script>
<!-- 模块增删改查主要js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/myaccount/myaccount.js"></script>
</body>
</html>