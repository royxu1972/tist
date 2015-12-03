<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/index.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/filemanager.css" />
<script type="text/javascript">
	var id = "";
	<% 
		String user_no = "";
		if(request.getParameter("id") != null){
			user_no = request.getParameter("id").toString();
		}
	%>
	id = '<%=user_no%>';
</script>
<title>课程详情</title>
</head>
<body>
	<!-- 引入公共头部菜单 -->
	<jsp:include page="/public/jsp/infopagehead.jsp"></jsp:include>

	<div class="container-fluid" id="below-nav">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						<div class="jumbotron" style="width:80%;margin-left:auto;margin-right:auto";>
						  <h2 id="course_name" class="info">课程名称</h2>
						  
						  <p>
						  	<dt>
								课程简介
							</dt>
							<dd id="introduction" class="info" style="text-indent:2em;">
								暂无课程简介
							</dd>
						  	<dt>
								课程大纲
							</dt>
							<dd id="outline" class="info" style="text-indent:2em;">
								暂无课程大纲
							</dd>
						  </p>
						  
						</div>
					</div>
					<div class="row" style="width:73%;margin-left:auto;margin-right:auto;text-align:center;">
                        <h3><strong>课件下载</strong></h3>
                        <div class="col-lg-12" id="course_files">
                            <div class="file-box">
                                <div class="file">
                                    <a href="#">
                                        <span class="corner"></span>

                                        <div class="icon">
                                            <i class="glyphicon glyphicon-file"></i>
                                        </div>
                                        <div class="file-name">
                                            Document_2014.doc
                                            <br/>
                                            <small>Added: Jan 11, 2014</small>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="file-box">
                                <div class="file">
                                    <a href="#">
                                        <span class="corner"></span>

                                        <div class="icon">
                                            <i class="img-responsive glyphicon glyphicon-facetime-video"></i>
                                        </div>
                                        <div class="file-name">
                                            Monica's birthday.mpg4
                                            <br/>
                                            <small>Added: Fab 18, 2014</small>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="file-box">
                                <div class="file">
                                    <a href="#">
                                        <span class="corner"></span>

                                        <div class="icon">
                                            <i class="glyphicon glyphicon-picture"></i>
                                        </div>
                                        <div class="file-name">
                                            Italy street.jpg
                                            <br/>
                                            <small>Added: Jan 6, 2014</small>
                                        </div>
                                    </a>

                                </div>
                            </div>
                            <div class="file-box">
                                <div class="file">
                                    <a href="#">
                                        <span class="corner"></span>

                                        <div class="icon">
                                            <i class="glyphicon glyphicon-music"></i>
                                        </div>
                                        <div class="file-name">
                                            Michal Jackson.mp3
                                            <br/>
                                            <small>Added: Jan 22, 2014</small>
                                        </div>
                                    </a>
                                </div>
                            </div>

                        </div>
                    </div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/index/courseinfo.js"></script>
</body>
</html>