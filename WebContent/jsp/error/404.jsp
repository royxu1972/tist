<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>页面躲起来鸟~</title>
<!-- 让IE以兼容性视图模式打开网页 注意前面不能有任何css或者js否则会影响浏览器解析模式 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/error/error.css" media="screen">
</head>

<body>
	<div id="container">
		<img class="png" src="${pageContext.request.contextPath}/images/error/404.png" /> 
		<img class="png msg" src="${pageContext.request.contextPath}/images/error/404_msg.png" />
		<p>
			<a href="${pageContext.request.contextPath}">
				<img class="png" src="${pageContext.request.contextPath}/images/error/404_to_index.png" />
			</a>
		</p>
	</div>
	<div id="cloud"></div>
</body>
</html>