<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/groupindex.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/pinboard.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/contact.css" />
<title>Group Information</title>
</head>
<body>
	
	<%-- <!-- Fixed navbar -->
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
	       <ul class="nav navbar-nav navbar-right">
	         <!-- <li><a href="#basic"><i class="glyphicon glyphicon-user"></i>&nbsp;基本信息</a></li>
	         <li><a href="#paper"><i class="glyphicon glyphicon-book"></i>&nbsp;已发表文献</a></li>
	         <li><a href="#project"><i class="glyphicon glyphicon-tags"></i>&nbsp;科研项目</a></li>
	         <li><a href="#stuproject"><i class="glyphicon glyphicon-leaf"></i>&nbsp;学生项目</a></li>
	         <li><a href="#homework"><i class="glyphicon glyphicon-edit"></i>&nbsp;学生作业</a></li>
	         <li><a href="#contact"><i class="glyphicon glyphicon-envelope"></i>&nbsp;联系我</a></li> -->
	       </ul>
	     </div><!--/.nav-collapse -->
	   </div>
	 </nav> --%>

	<div class="container-fluid" id="below-nav">
		<div class="row-fluid" id="div_group_info">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-info-sign"></i>&nbsp;项目组介绍</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12">
								<!-- <h2 id="group_zhname" style="text-align:center;"></h2> -->
								<p id="group_zhinfo" style="text-indent:2em;"></p>
								<!-- <h2 id="group_enname" style="text-align:center;"></h2>
								<p id="group_eninfo" style="text-indent:2em;"></p> -->
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row-fluid" id="div_group_member">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-user"></i>&nbsp;项目组成员</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12">
								<h4>老师</h4>
								<div class="row" id="teachers">
									<div class="col-lg-4">
						                <div class="contact-box">
						                    <a href="#">
							                    <div class="col-sm-4">
							                        <div class="text-center">
							                            <img alt="image" class="img-circle m-t-xs img-responsive" src="${pageContext.request.contextPath}/bjsp/basicinfo/man128.png">
							                            <div class="m-t-xs font-bold">Graphics designer</div>
							                        </div>
							                    </div>
							                    <div class="col-sm-8">
							                        <h4><strong>John Smith</strong></h4>
							                        <p><i class="fa fa-map-marker"></i> Riviera State 32/106</p>
							                        <address>
							                            <strong>Twitter, Inc.</strong><br>
							                            795 Folsom Ave, Suite 600<br>
							                            San Francisco, CA 94107<br>
							                            <abbr title="Phone">P:</abbr> (123) 456-7890
							                        </address>
							                    </div>
							                    <div class="clearfix"></div>
					                        </a>
						                </div>
						            </div>
									<div class="col-lg-4">
						                <div class="contact-box">
						                    <a href="#">
							                    <div class="col-sm-4">
							                        <div class="text-center">
							                            <img alt="image" class="img-circle m-t-xs img-responsive" src="${pageContext.request.contextPath}/bjsp/basicinfo/man128.png">
							                            <div class="m-t-xs font-bold">CEO</div>
							                        </div>
							                    </div>
							                    <div class="col-sm-8">
							                        <h4><strong>Alex Johnatan</strong></h4>
							                        <p><i class="fa fa-map-marker"></i> Riviera State 32/106</p>
							                        <address>
							                            <strong>Twitter, Inc.</strong><br>
							                            795 Folsom Ave, Suite 600<br>
							                            San Francisco, CA 94107<br>
							                            <abbr title="Phone">P:</abbr> (123) 456-7890
							                        </address>
							                    </div>
							                    <div class="clearfix"></div>
					                        </a>
						                </div>
						            </div>
									<div class="col-lg-4">
						                <div class="contact-box">
						                    <a href="#">
							                    <div class="col-sm-4">
							                        <div class="text-center">
							                            <img alt="image" class="img-circle m-t-xs img-responsive" src="${pageContext.request.contextPath}/bjsp/basicinfo/man128.png">
							                            <div class="m-t-xs font-bold">Marketing manager</div>
							                        </div>
							                    </div>
							                    <div class="col-sm-8">
							                        <h4><strong>Monica Smith</strong></h4>
							                        <p><i class="fa fa-map-marker"></i> Riviera State 32/106</p>
							                        <address>
							                            <strong>Twitter, Inc.</strong><br>
							                            795 Folsom Ave, Suite 600<br>
							                            San Francisco, CA 94107<br>
							                            <abbr title="Phone">P:</abbr> (123) 456-7890
							                        </address>
							                    </div>
							                    <div class="clearfix"></div>
					                        </a>
						                </div>
						            </div>
								</div>
								<h4>学生</h4>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row-fluid" id="div_notice">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive" style="color:blue;"><i class="glyphicon glyphicon-envelope"></i>&nbsp;通知消息</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12">
							<ul class="notes" id="notices">
		                        <li>
		                            <div>
		                                <small>12:03:28 12-04-2014</small>
		                                <h4>Long established fact</h4>
		                                <p>The years, sometimes by accident, sometimes on purpose (injected humour and the like).</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                        <li>
		                            <div>
		                                <small>11:08:33 16-04-2014</small>
		                                <h4>Latin professor at Hampden-Sydney </h4>
		                                <p>The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                        <li>
		                            <div>
		                                <small>9:12:28 10-04-2014</small>
		                                <h4>The standard chunk of Lorem</h4>
		                                <p>Ipsum used since the 1500s is reproduced below for those interested.</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                        <li>
		                            <div>
		                                <small>3:33:12 6-03-2014</small>
		                                <h4>The generated Lorem Ipsum </h4>
		                                <p>The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                        <li>
		                            <div>
		                                <small>5:20:11 4-04-2014</small>
		                                <h4>Contrary to popular belief</h4>
		                                <p>Hampden-Sydney College in Virginia, looked up one.</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                        <li>
		                            <div>
		                                <small>2:10:12 4-05-2014</small>
		                                <h4>There are many variations</h4>
		                                <p>All the Lorem Ipsum generators on the Internet .</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                        <li>
		                            <div>
		                                <small>10:15:26 6-04-2014</small>
		                                <h4>Ipsum used standard chunk of Lorem</h4>
		                                <p>Standard chunk  is reproduced below for those.</p>
		                                <a href="#"><i class="fa fa-trash-o "></i></a>
		                            </div>
		                        </li>
		                    </ul>
							</div>
							
						</div>
					</div>
					
				</div>
			</div>
		</div>
	 </div>
	
	<nav id="footer" class="footer">
	    <strong>Copyright</strong> Royxu &copy; 2014-2015 &nbsp;All Rights Reserved.
	</nav>
<!-- 模块增删改查主要js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/index/groupindex.js"></script>
</body>
</html>