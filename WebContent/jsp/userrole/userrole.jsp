<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/userrole/userrole.js"></script>
<style type="text/css">
#role_checkbox td{
	width : 25%;
	text-align : center;
	vertical-align:middle;
}

#role_checkbox input{
	vertical-align:middle;
}
</style>
<title>用户角色分配</title>
</head>
<body class="easyui-layout" fit="true" border="false">
	<div data-options="region:'west',split:false" style="width:55%;">
		<div class="easyui-layout" style="width:100%;height:100%;">   
		    <div data-options="region:'north',title:'操作',split:false" style="height:60px;width:100%;">
		    	<div class="datagrid-toolbar">
					<table cellpadding="0" cellspacing="0" style="width: 100%">
						<tr>
							<td>
								<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
							</td>
						</tr>
					</table>
				</div>
		    </div>
		    
		    <div data-options="region:'center',title:'系统角色'" style="padding:5px;">
		    	<table id="datagrid"  style="width:700px;height:300px"></table>
		    </div>
		</div>
		
	</div>
	
	<div data-options="region:'east',title:'角色信息',split:false" style="width:45%;">
    	<div class="easyui-layout" style="width:100%;height:100%;">   
		    <div data-options="region:'north',split:false" style="height:100%;">
		    	<form id="form" method="post" novalidate class="ui-form">
					<input name="increment_id" id="increment_id" type="hidden" />
					<input name="user_id" id="user_id" type="hidden" />
					<input name="role_ids" id ="role_ids" type="hidden" />
					
					<div class="ui-form-item">
						<label for="user_name" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>用户名</label>
						<input name="user_name" id="user_name" class="easyui-textbox" readonly="true">
					</div>
					
					<br/>
					
					<div class="ui-form-item">
						<label for="role_checkbox" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>角色选择</label>
						<table id="role_checkbox" style="width:80%;">
							
						</table>
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
		    
		</div>  
    </div>
	
</body>
</html>