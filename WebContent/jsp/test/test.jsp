<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<title>label 标签右对齐</title>
<style type="text/css">
.form_label {display:block; width:200px; text-align:right;}
.form_input {display:block; height:20px; padding-left:200px; margin-top:-30px;}
</style>
</head>
<body>
<form id="form">
    <div>
        <label for="user_name" class="form_label">用户名:</label>
        <input class="easyui-textbox form_input" id="user_name" name="user_name" data-options="iconCls:'icon-man',iconWidth:30" style="width:200px;height:20px;" prompt="仅支持大小写英文字母" />
    </div>
    <div>
        <label for="user_password" class="form_label">密码:</label>
        <input class="easyui-textbox form_input" type="password" id="user_password" name="user_password" data-options="iconCls:'icon-lock',iconWidth:30" style="width:200px;height:20px;" prompt="长度不小于6位">
    </div>
    <a class="easyui-linkbutton" id="submit">注册</a>
</form>
</body>
</html>

