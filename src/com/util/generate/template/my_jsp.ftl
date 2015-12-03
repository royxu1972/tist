<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 引入公共头部，里面有easyui基本文件 -->
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/page.js"></script>
<script type="text/javascript" src="${contextPath}/js/dateformat.js"></script>
<!-- <script type="text/javascript" src="${contextPath}/js/public.js"></script> --><!-- 是否需要公共js(js变量空判断) -->
<script type="text/javascript" src="${contextPath}/jsp/${classname}/${classname}.js"></script>
<title>${functionName}</title>
</head>
<body class="easyui-layout" fit="true" border="false">
	<!-- easyui的北部布局，主要放工具栏 -->
	<div region="north" border="false">
		<div class="datagrid-toolbar">
			<table cellpadding="0" cellspacing="0" style="width: 100%">
				<tr>
					<td>
					 	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>  
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- easyui的中部布局，放一个easyui的datagrid列表，用户展示数据 -->
	<div region="center" border="false" style="overflow: hidden;">
		<table id="datagrid" style="width:700px;height:300px">
        </table>
	</div>
	
	<!-- 
		easyui的对话框，它不属于布局内部的一部分，只有在增加和编辑的时候调用这个对话框。
		增加的时候显示一个空表单的对话框。
		编辑的时候将选中的某行数据载入表单中。		
	 -->
	<div id="dialog" class="easyui-dialog"
		style="width:600px; height: 450px;" closed="true"
		modal="true" maximizable="true" maximized="true" buttons="#dlg-buttons">
		<form id="form" method="post" novalidate class="ui-form">
			<!-- 表单可用class ui-form-item2 fn-left/fn-right -->
			<#list fields as fld>
			<div class="ui-form-item2 fn-left">
				<label for="${fld.field_name}" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>${fld.field_comment}</label>
				<input name="${fld.field_name}" id="${fld.field_name}" class="easyui-textbox" required="true" missingMessage="必填" />
			</div>
			
			</#list>
			
			<div id="ids"></div>
			<!-- 表单不需要显示的字段-->
			<div style="display:none">
				<!-- 主键值-->
				<input name="increment_id" id="increment_id" />
				<!-- 表单提交的时候对应的操作方法。-->
				<input name="_method" value="post"/>
			</div>
		</form>
		
		<!-- 对话框的确定和取消按钮 -->
		<div id="dlg-buttons">
			<a href="#" class="easyui-linkbutton" id="submit" iconCls="icon-ok">确定</a> 
			<a href="#" class="easyui-linkbutton" id="cancel" iconCls="icon-cancel" onclick="javascript:$('#dialog').dialog('close')">取消</a>
		</div>
	</div>
	
</body>
</html>
