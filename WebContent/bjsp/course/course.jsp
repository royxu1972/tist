<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<%-- <jsp:include page="/public/jsp/summernoteInc.jsp"></jsp:include> --%>
<jsp:include page="/public/jsp/ueditorInc.jsp"></jsp:include>
<title>教学课程</title>
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
								<font color="#08C"style="font-size:20px;font-family:微软雅黑;">教学课程</font>
							</div>
						</div>
					</div>
				</div>
				
				<!-- table工具栏 -->
				<div class="container-fluid" id="table_toolbar">
					<div class="row-fluid">
						<div class="span12">
							<div class="btn-group" role="group" aria-label="...">
								<button type="button" class="btn btn-default tool_buttons" id="create"><i class="glyphicon glyphicon-plus"></i>&nbsp;新&nbsp;增</button>
								<button type="button" class="btn btn-default tool_buttons" id="edit"><i class="glyphicon glyphicon-pencil"></i>&nbsp;编&nbsp;辑</button>
								<button type="button" class="btn btn-default tool_buttons" id="remove"><i class="glyphicon glyphicon-remove"></i>&nbsp;删&nbsp;除</button>
							</div>
						</div>
					</div>
				</div>
				
				<!-- bootstraptable -->
				<table id="data_table"></table>
				
			</div>
		</div>
	</div>
		
	<!-- Modal对话框 -->
	<div id="dialog" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <!-- 对话框关闭按钮 -->
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <!-- 对话框标题 -->
	        <h4 class="modal-title" id="dialog_title">Modal title</h4>
	      </div>
	      <div class="modal-body">
			<!-- 表单部分 -->
			<form class="form-horizontal" id="data_form">
				  <div class="form-group">
				    <label for="course_name" class="col-sm-3 control-label">课程名称</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="course_name" name="course_name">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="course_grades" class="col-sm-3 control-label">授课年级</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="course_grades" name="course_grades">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="course_length" class="col-sm-3 control-label">课时</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="course_length" name="course_length">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="course_intro" class="col-sm-3 control-label">课程介绍</label>
				    <div class="col-sm-9">
				      <textarea class="form-control" id="course_intro" name="course_intro" title="课程介绍"></textarea>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="course_outline" class="col-sm-3 control-label">课程大纲</label>
				    <div class="col-sm-9">
				      <textarea class="form-control" id="course_outline" name="course_outline" title="课程大纲"></textarea>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="support_fund" class="col-sm-3 control-label">课件列表</label>
				    <div class="col-sm-9" id="file_list">
				      
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="support_fund" class="col-sm-3 control-label">添加课程附件</label>
				    <div class="col-sm-9">
				      <button type="button" class="btn btn-info btn-sm" onclick="addFileUpload();">
				      	<i class="glyphicon glyphicon-level-up"></i>&nbsp;添加课件
				      </button>
				    </div>
				  </div>
			  
			  <!-- 删除时使用 -->
			  <div id="ids" type="hidden"></div>
			  <!-- 表单隐藏部分 -->
			  <div style="display:none;">
			  	  <div class="form-group">
				    <label for="course_id" class="col-sm-3 control-label">课程主键id</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="increment_id" name="course_id">
				    </div>
				  </div>
			  	<input name="_method" value="post"/>
			  	<input id="user_no" name="user_no"/>
			  </div>
			  
			</form>
			
	      </div>
	      <!-- 对话框确定取消按钮 -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">
	        	<i class="glyphicon glyphicon-off"></i>&nbsp;关&nbsp;闭
	        </button>
	        <button type="button" class="btn btn-primary" id="submit">
	        	<i class="glyphicon glyphicon-ok"></i>&nbsp;保&nbsp;存
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<jsp:include page="/public/jsp/ueditor_dialog.jsp"></jsp:include>

<!-- 多文件上传js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/ajaxfileupload_new.js"></script>
<!-- 表单验证js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/course/course_validate.js"></script>
<!-- 模块增删改查主要js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/course/course.js"></script>
</body>
</html>