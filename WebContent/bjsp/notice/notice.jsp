<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<title>通知消息</title>
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
								<font color="#08C"style="font-size:20px;font-family:微软雅黑;">通知消息</font>
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
				    <label for="notice_title" class="col-sm-3 control-label">消息标题</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="notice_title" name="notice_title">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="notice_content" class="col-sm-3 control-label">消息内容</label>
				    <div class="col-sm-9">
				      <textarea class="form-control" id="notice_content" name="notice_content"></textarea>
				    </div>
				  </div>
			  
			  <!-- 删除时使用 -->
			  <div id="ids" type="hidden"></div>
			  <!-- 表单隐藏部分 -->
			  <div style="display:none;">
			  	<div class="form-group">
				    <label for="notice_id" class="col-sm-3 control-label">消息id</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="notice_id" name="notice_id">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="del_flag" class="col-sm-3 control-label">删除标志位</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="del_flag" name="del_flag">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="author" class="col-sm-3 control-label">发布人</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="author" name="author">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="notice_time" class="col-sm-3 control-label">消息日期</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="notice_time" name="notice_time">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="notice_origin" class="col-sm-3 control-label">消息出处</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="notice_origin" name="notice_origin">
				    </div>
				  </div>
			  	<input id="increment_id" name="increment_id">
			  	<input name="_method" value="post"/>
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
	
<!-- 表单验证js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/notice/notice_validate.js"></script>
<!-- 模块增删改查主要js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/notice/notice.js"></script>
</body>
</html>