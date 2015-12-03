<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	<% 
		String user_name = "";
		if(session.getAttribute("user_name") != null){
			user_name = session.getAttribute("user_name").toString();
		}
	%>
</script>
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dateformat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/index/index.js"></script>
<title>royxu管理系统</title>
<style type="text/css">
body {
	font: 12px/20px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: underline;
}
a:active {
 text-decoration: none;
}
.cs-north {
	height:60px;background:#B3DFDA;
}
.cs-north-bg {
	width: 100%;
	height: 100%;
	background: url(../../easyui1.4/themes/gray/images/header_bg.png) repeat-x;
}
.cs-north-logo {
	height: 40px;
	padding: 15px 0px 0px 5px;
	color:#fff;font-size:22px;font-weight:bold;text-decoration:none
}
.cs-west {
	width:200px;padding:0px;border-left:1px solid #99BBE8;
}
.cs-south {
	height:25px;background:url('../../easyui1.4/themes/gray/images/panel_title.gif') repeat-x;padding:0px;text-align:center;
}
.cs-navi-tab {
	padding: 5px;
}
.cs-tab-menu {
	width:120px;
}
.cs-home-remark {
	padding: 10px;
}

#div_father {
	position: absolute;
}

#div_exit {
	position: relative;
	float: right;
	width: 500px;
	margin-right: 5px;
	z-index: 1;
	text-align : right;
}
</style>
</head>
<body class="easyui-layout">
	<div region="north" border="true" class="cs-north">
		<div class="cs-north-bg" id="div_father">
			<div class="cs-north-logo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           	royxu管理系统</div>
        </div>
        <div id="div_exit">
        	欢迎您，<label id="role_id_name" style="color:blue;"><%=user_name %></label>
        	<a class="easyui-linkbutton" id="chenge_identity" iconCls="icon-man" plain="true" target="_parent" href="${pageContext.request.contextPath}//jsp/login/roleselect.jsp">切换身份</a>
        	<a target="_parent" class="easyui-linkbutton" plain="true" iconCls="icon-logout" href="${pageContext.request.contextPath}/logout.do">退出系统</a>
        </div>
	</div>
	<div region="west" border="true" split="true" title="导航侧边栏" class="cs-west">
		<div id="left_accordion" class="easyui-accordion" fit="true" border="false">
		</div>
	</div>
	<div id="mainPanle" region="center" border="true" border="false">
		 <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
                <div title="主页">
				<div class="cs-home-remark">
					<h1>royxu管理系统DEMO</h1> <br>
					制作：lh <br>
					<br> <br/>
					说明：根据easeui文档制作。
				</div>
				</div>
        </div>
	</div>

	<div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div>
</body>
</html>