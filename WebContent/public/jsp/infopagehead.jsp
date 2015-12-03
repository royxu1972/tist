<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
       <a class="navbar-brand" href="${pageContext.request.contextPath}/bjsp/login/login.jsp">Royxu</a>
     </div>
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav">
         <li><a href="${pageContext.request.contextPath}/bjsp/index/groupindex.jsp"><i class="glyphicon glyphicon-home"></i>&nbsp;回到首页</a></li>
       </ul>
       <!-- <ul class="nav navbar-nav navbar-right">
         <li><a href="../navbar/">Default</a></li>
         <li><a href="../navbar-static-top/">Static top</a></li>
         <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
       </ul> -->
     </div><!--/.nav-collapse -->
   </div>
 </nav>