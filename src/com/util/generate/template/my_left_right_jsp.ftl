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
	<div data-options="region:'west',split:false" style="width:55%;">
		<div class="easyui-layout" style="width:100%;height:100%;">   
		    <div data-options="region:'north',title:'操作',split:false" style="height:60px;width:100%;">
		    	<div class="datagrid-toolbar">
					<table cellpadding="0" cellspacing="0" style="width: 100%">
						<tr>
							<td>
								<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
							</td>
						</tr>
					</table>
				</div>
		    </div>
		    
		    <div data-options="region:'center',title:'${functionName}'" style="padding:5px;">
		    	<table id="datagrid" style="width:700px;height:300px"></table>
		    </div>
		</div>
		
	</div>
	
	<div data-options="region:'east',title:'${functionName}信息',split:false" style="width:45%;">
    	<div class="easyui-layout" style="width:100%;height:100%;">   
		    <div data-options="region:'north',split:false" style="height:100%;">
		    	<form id="form" method="post" novalidate class="ui-form">
		
					<!-- 表单可用class ui-form-item2 fn-left/fn-right -->
					<#list fields as fld>
					<div class="ui-form-item">
						<label for="${fld.field_name}" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>${fld.field_comment}</label>
						<input name="${fld.field_name}" id="${fld.field_name}" class="easyui-textbox" required="true" missingMessage="必填" />
					</div>
					
					</#list>
					
					<div id="ids"></div>
					<!-- 表单不需要显示的字段-->
					<div style="display:none">
						<!-- 主键值-->
						<input name="increment_id" id="increment_id" />
						<!-- <input name="del_flag" id="del_flag" /> -->
						<!-- 表单提交的时候对应的操作方法。-->
						<input type="hidden" name="_method" value="post"/>
					</div>
				</form>
				
				<!-- 对话框的确定和取消按钮 -->
				<div id="dlg-buttons" style="width:100%;height:100%;text-align:center;">
					<a href="#" class="easyui-linkbutton" id="submit" iconCls="icon-ok">确定</a> 
					<a href="#" class="easyui-linkbutton" id="cancel" iconCls="icon-cancel" onclick="javascript:$('#form').form('clear');create();">清空</a>
				</div>
		    </div>
		    
		</div>  
    </div>
	
</body>
</html>
