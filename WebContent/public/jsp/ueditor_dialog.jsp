<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8" />
<!-- Modal对话框 -->
<div id="summer_dialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- 对话框关闭按钮 -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <!-- 对话框标题 -->
        <h4 class="modal-title" id="summer_title">Modal title</h4>
      </div>
      <div class="modal-body">
		<!-- <div class="summernote" id="summernote"></div> -->
		<script id="summernote" type="text/plain" style="height:450px;"></script>
      </div>
      <!-- 对话框确定取消按钮 -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
        	<i class="glyphicon glyphicon-off"></i>&nbsp;关&nbsp;闭
        </button>
        <button type="button" class="btn btn-primary tool_buttons" id="summernote_confirm">
        	<i class="glyphicon glyphicon-ok"></i>&nbsp;确&nbsp;定
        </button>
      </div>
    </div>
  </div>
</div>