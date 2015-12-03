<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/codegenerate/codegenerate.js"></script>
<style type="text/css">
.my_checkbox{
	vertical-align:middle;
}
.ui-form-item-label {
	width : 12%;
}
</style>
<title>代码生成器</title>
</head>
<body class="easyui-layout" fit="true" border="false">
	<div data-options="region:'west',split:false,title:'源码及MySQL表结构'" style="width:50%;">
		<form id="form" method="post" novalidate class="ui-form">
			<input name="increment_id" id="increment_id" type="hidden" />
			
			<div class="ui-form-item">
				<label for="class_name" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>Java类名</label>
				<input name="class_name" id="class_name" class="easyui-validatebox" required="true">
				<span style="color:blue;">如:user 或 userInformation(首字母小写,第二个单词开始首字母大写)</span>
			</div>
			
			<div class="ui-form-item">
				<label for="function_name" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>功能模块名</label>
				<input name="function_name" id="function_name" class="easyui-validatebox" required="true">
				<span style="color:blue;">如:用户、订单</span>
			</div>
			
			<div class="ui-form-item">
				<label for="module_name" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>表前缀</label>
				<input name="module_name" id="module_name" class="easyui-validatebox" required="true">
				<span style="color:blue;">如:sys、shoporder</span>
			</div>
			
			<div class="ui-form-item">
				<label class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>&nbsp;</label>
				<input id="generate_jspjs" type="checkbox" class="my_checkbox">
				<label for="generate_jspjs" class="my_checkbox" style="width:15px;">生成jsp和js</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<!-- <input id="left_right" type="checkbox" class="my_checkbox">
				<label for="left_right" class="my_checkbox" style="width:15px;">生成左右结构jsp，右侧为表单</label> -->
			</div>
			
			<div class="ui-form-item">
				<label for="java_members" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>Java类成员</label>
				<textarea name="java_members" id="java_members" rows="15" style="width:80%;"></textarea>
				<br/>
				<span style="color:blue;">格式：数据类型（空格）成员名称（空格）注释（空格）长度（回车）缺一不可。<br/>如：<br/>int user_id 用户id 11&nbsp;&nbsp;&nbsp;(回车换行)<br/>String user_name 用户名 30</span>
			</div>
			
			<!-- 表单提交的时候对应的操作方法。-->
            <input type="hidden" name="_method" value="post"/>
		</form>
		
		<!-- 对话框的确定和取消按钮 -->
		<div id="dlg-buttons" style="width:100%;height:100%;text-align:center;">
			<a href="#" class="easyui-linkbutton" id="submit" iconCls="icon-ok">确定</a> 
			<a href="#" class="easyui-linkbutton" id="cancel" iconCls="icon-cancel" onclick="clearForm();">清空</a>
		</div>
	</div>
	
	<div data-options="region:'east',title:'生成源码',split:false" style="width:50%;height:100%;">
    	<form id="form2" method="post" novalidate class="ui-form">
			
			<!-- <div class="ui-form-item">
				<label for="get_set" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>get/set方法</label>
				<textarea name="get_set" id="get_set" rows="15" style="width:80%;"></textarea>
			</div> -->
			
			<div class="ui-form-item">
				<label for="module_generate" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>代码生成结果</label>
				<textarea name="module_generate" id="module_generate" rows="15" style="width:80%;"></textarea>
			</div>
			
			<!-- <div class="ui-form-item">
				<label for="form_code" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>表单代码</label>
				<textarea name="form_code" id="form_code" rows="15" style="width:80%;"></textarea>
			</div>
			
			<div class="ui-form-item">
				<label for="field_js" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>js代码</label>
				<textarea name="field_js" id="field_js" rows="15" style="width:80%;"></textarea>
			</div> -->
			
		</form>
    </div>
	
</body>
</html>