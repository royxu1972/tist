<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<%-- <jsp:include page="/public/jsp/summernoteInc.jsp"></jsp:include> --%>
<jsp:include page="/public/jsp/ueditorInc.jsp"></jsp:include>
<title>基本信息</title>
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
								<font color="#08C"style="font-size:20px;font-family:微软雅黑;">基本信息</font>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 表单部分 -->
				<form class="form-horizontal" id="data_form">
				  <div class="form-group">
				    <label for="pic" class="col-sm-2 control-label">照片</label>
				    <div class="col-sm-10" id="divPreview">
				      <img src="${pageContext.request.contextPath}/bjsp/basicinfo/man128.png" alt="" id="myphoto" width="140px" height="140px" class="img-circle">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="file" class="col-sm-2 control-label">上传照片</label>
				    <div class="col-sm-10">
				      <input type="file" accept="image/*" onchange="preview(this);" id="file" name="files">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="name" name="name">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="en_name" class="col-sm-2 control-label">英文名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="en_name" name="en_name">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="gender" class="col-sm-2 control-label">性别</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="gender" name="gender">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="birthday" class="col-sm-2 control-label">出生年月</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="birthday" name="birthday">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="academic" class="col-sm-2 control-label">学历</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="academic" name="academic">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="pro_title" class="col-sm-2 control-label">职称</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="pro_title" name="pro_title">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="research_area" class="col-sm-2 control-label">研究方向</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="research_area" name="research_area">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="member_role" class="col-sm-2 control-label">项目组承担角色</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="member_role" name="member_role">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="email" class="col-sm-2 control-label" id="lbl_email">邮箱</label>
				    <div class="col-sm-10" id="div_email">
				      <input type="text" class="form-control" id="email" name="email">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="member_site" class="col-sm-2 control-label">个人网站</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="member_site" name="member_site">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="address" class="col-sm-2 control-label">联系地址</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="address" name="address">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="zh_introduction" class="col-sm-2 control-label">中文简介</label>
				    <div class="col-sm-10">
				      <textarea class="form-control" id="zh_introduction" name="zh_introduction" title="中文简介"></textarea>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="en_introduction" class="col-sm-2 control-label">英文简介</label>
				    <div class="col-sm-10">
				      <textarea class="form-control" id="en_introduction" name="en_introduction" title="英文简介"></textarea>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="detail_introduction" class="col-sm-2 control-label">详细介绍</label>
				    <div class="col-sm-10">
				      <textarea class="form-control" id="detail_introduction" name="detail_introduction" title="详细介绍"></textarea>
				    </div>
				  </div>
			  
				  <!-- 删除时使用 -->
				  <div id="ids" type="hidden"></div>
				  <!-- 表单隐藏部分 -->
				  <div style="display:none;">
				  	<input id="increment_id" name="increment_id">
				  	<input id="member_type" name="member_type">
				  	<input id="member_sort" name="member_sort">
				  	<input id="email_validated" name="email_validated">
				  	<input name="_method" value="post"/>
				  </div>
				  
				</form>
				
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				        <button type="button" class="btn btn-primary" id="submit">
				        	<i class="glyphicon glyphicon-ok"></i>&nbsp;保&nbsp;存
				        </button>
				    </div>
				  </div>
				
			</div>
		</div>
	</div>
		
	<jsp:include page="/public/jsp/ueditor_dialog.jsp"></jsp:include>
	
	<!-- Modal对话框 -->
	<div id="dialog" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <!-- 对话框关闭按钮 -->
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <!-- 对话框标题 -->
	        <h4 class="modal-title" id="dialog_title">邮箱验证</h4>
	      </div>
	      <div class="modal-body">
			<!-- 表单部分 -->
			<form class="form-horizontal" id="email_form">
				  <div class="form-group">
				    <label for="my_email" class="col-sm-3 control-label">邮箱</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="my_email" name="my_email" readonly="true">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="btn_getvalidatecode" class="col-sm-3 control-label">&nbsp;</label>
				    <div class="col-sm-9">
				      <button type="button" class="btn btn-info" onclick="settime(this);getValidateCode();" id="btn_getvalidatecode">获取验证码</button>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="validate_code" class="col-sm-3 control-label">您收到的验证码</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="validate_code" name="validate_code">
				    </div>
				  </div>
			  <!-- 表单隐藏部分 -->
			  <div style="display:none;">
			  	<input id="my_user_no" name="my_user_no"/>
			  </div>
			  
			</form>
			
	      </div>
	      <!-- 对话框确定取消按钮 -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">
	        	<i class="glyphicon glyphicon-off"></i>&nbsp;关&nbsp;闭
	        </button>
	        <button type="button" class="btn btn-primary" onclick="validateMyEmail();">
	        	<i class="glyphicon glyphicon-ok"></i>&nbsp;验&nbsp;证
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	
<!-- 多文件上传js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/ajaxfileupload_new.js"></script>
<!-- 表单验证js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/basicinfo/basicinfo_validate.js"></script>
<!-- 模块增删改查主要js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/basicinfo/basicinfo.js"></script>
</body>
</html>