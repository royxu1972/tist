<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/groupindex.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/pinboard.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/contact.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/message.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/animate.css" />
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
	 
	<div id="div-static-topright">
		<ul>
			<li class="dropdown">
				<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
					<i class="glyphicon glyphicon-bell animated shake"></i><span class="label label-warning animated bounceIn">3</span>
				</a>
                 <ul class="dropdown-menu dropdown-messages" id="ul_messages">
                     <li>
                         <div class="dropdown-messages-box">
                             <div class="media-body">
                                 <small class="pull-right">46h ago</small>
                                 <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                 <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                             </div>
                         </div>
                     </li>
                     <li class="divider"></li>
                 </ul>
             </li>
		</ul>
	</div>

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
								<!-- <h4>学生</h4> -->
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row-fluid" id="paper">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-book"></i>&nbsp;已发表文献</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12">
								<ol id="ol_paper">
									<li>
										梁轰,王江平,徐家喜,<a href="#">基于Android的校园网站客户端的设计与实现</a>,电脑知识与技术,2015-06
										<a href="#"><i class="glyphicon glyphicon-circle-arrow-down"></i>下载文献附件</a>
									</li>
									<li>
										梁轰,王江平,徐家喜,<a href="#">公钥证书在Android APP访问校园网中的应用</a>,南京晓庄学院学报,2014-12
										<a href="#"><i class="glyphicon glyphicon-circle-arrow-down"></i>下载文献附件</a>
									</li>
								</ol>
							</div>
							<div class="span12" align="center">
								<div>
									<ul class="pagination" id="goods_page">
										<li><a href="#">&laquo;</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>
								<!-- <div>当前第&nbsp;<span id="current_page"></span>&nbsp;页，共&nbsp;<span id="total_page"></span>&nbsp;页</div> -->
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row-fluid" id="project">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-tags"></i>&nbsp;项目一览</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12">
								<ul class="thumbnails" id="ul_proj">
									<li class="span4">
										<div class="thumbnail1">
											<div class="caption">
												<h4>
													冯诺尔曼结构
												</h4>
												<p>
													也称普林斯顿结构，是一种将程序指令存储器和数据存储器合并在一起的存储器结构。程序指令存储地址和数据存储地址指向同一个存储器的不同物理位置。
												</p>
												<p>
													<a class="btn btn-info btn-sm" href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;浏览</a>
												</p>
											</div>
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
<script type="text/javascript">
	var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cspan id='cnzz_stat_icon_1256890950'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1256890950%26show%3Dpic2' type='text/javascript'%3E%3C/script%3E"));
	//$("#footer").append(unescape("%3Cspan id='cnzz_stat_icon_1256890950'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1256890950%26show%3Dpic2' type='text/javascript'%3E%3C/script%3E"));
	$("#cnzz_stat_icon_1256890950").appendTo($("#footer"));
</script>
</body>
</html>