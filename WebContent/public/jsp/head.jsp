<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	<% 
		String user_name = "";
		if(session.getAttribute("user_name") != null){
			user_name = session.getAttribute("user_name").toString();
		}
	%>
</script>
<!-- Fixed navbar -->
 <nav class="navbar navbar-default navbar-fixed-top">
   <div class="container">
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
         <span class="sr-only">导航栏</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#">Admin(<%=user_name %>)</a>
     </div>
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav" id="top_menus">
         <%-- <li><a href="${pageContext.request.contextPath}/bjsp/index/index.jsp">首页</a></li>
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息管理&nbsp;<span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="${pageContext.request.contextPath}/bjsp/basicinfo/basicinfo.jsp">基本信息</a></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/experience/experience.jsp">个人经历</a></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/award/award.jsp">个人荣誉</a></li>
             <li role="separator" class="divider"></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/paper/paper.jsp">文献管理</a></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/scienceproject/scienceproject.jsp">科研项目</a></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/studentproject/studentproject.jsp">学生项目</a></li>
           </ul>
         </li>
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">教学管理&nbsp;<span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="${pageContext.request.contextPath}/bjsp/course/course.jsp">教学课程</a></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/homework/homework.jsp">教学作业</a></li>
           </ul>
         </li>
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">项目组管理&nbsp;<span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="${pageContext.request.contextPath}/bjsp/projectgroup/projectgroup.jsp">项目组基本信息</a></li>
             <li><a href="${pageContext.request.contextPath}/bjsp/groupmember/groupmember.jsp">项目组成员管理</a></li>
             
           </ul>
         </li>
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统功能&nbsp;<span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="${pageContext.request.contextPath}/bjsp/notice/notice.jsp">通知消息</a></li>
             <li role="separator" class="divider"></li>
             <li><a target="_blank" href="${pageContext.request.contextPath}/jsp/role/role.jsp">角色管理</a></li>
             <li><a target="_blank" href="${pageContext.request.contextPath}/jsp/userrole/userrole.jsp">用户角色分配</a></li>
           </ul>
         </li> --%>
       </ul>
       <ul class="nav navbar-nav navbar-right" id="top_right_menu">
         <%-- <li><a href="${pageContext.request.contextPath}/bjsp/myaccount/myaccount.jsp"><i class="glyphicon glyphicon-lock"></i>&nbsp;修改密码</a></li>
         <li><a href="${pageContext.request.contextPath}/logout.do"><i class="glyphicon glyphicon-log-out"></i>&nbsp;退出系统</a></li> --%>
       </ul>
     </div><!--/.nav-collapse -->
   </div>
 </nav>