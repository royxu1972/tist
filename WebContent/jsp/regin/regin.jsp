<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dateformat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/regin/regin.js"></script>
<title>新用户注册</title>
</head>
<body class="easyui-layout">  
    <div region="north" title="North Title" split="true" style="height:100px;"></div>  
    <div region="south" title="South Title" split="true" style="height:100px;"></div>  
    <div region="east" iconCls="icon-reload" title="East" split="true" style="width:100px;"></div>  
    <div region="west" split="true" title="West" style="width:100px;"></div>  
    <div region="center" title="center title" style="padding:5px;background:#eee;">
    <form id="form">
	    <div>
	        <label for="user_name" class="ui-form-item2-label">用户名:</label>
	        <input class="easyui-textbox ui-form-item2-input" id="user_name" name="user_name" data-options="iconCls:'icon-man',iconWidth:30" style="width:200px;height:20px;" prompt="仅支持大小写英文字母" />
	    </div>
	    <div>
	        <label for="user_password" class="ui-form-item2-label">密码:</label>
	        <input class="easyui-textbox ui-form-item2-input" type="password" id="user_password" name="user_password" data-options="iconCls:'icon-lock',iconWidth:30" style="width:200px;height:20px;" prompt="长度不小于6位">
	    </div>
	    <a class="easyui-linkbutton" id="submit">注册</a>
	</form>
    </div>  
</body> 
</html>