<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/index.css" />
<script type="text/javascript">
	var id = "";
	<% 
		String user_no = "";
		if(request.getParameter("id") != null){
			user_no = request.getParameter("id").toString();
		}else if(session.getAttribute("user_no") != null){
			user_no = session.getAttribute("user_no").toString();
		}
	%>
	id = '<%=user_no%>';
</script>
<title>Royxu个人首页</title>
</head>
<body>
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
	       <a class="navbar-brand" href="${pageContext.request.contextPath}/bjsp/login/login.jsp">TIST</a>
	     </div>
	     <div id="navbar" class="navbar-collapse collapse">
	       <ul class="nav navbar-nav navbar-left">
	         <li><a href="${pageContext.request.contextPath}/bjsp/index/groupindex.jsp"><i class="glyphicon glyphicon-home"></i>&nbsp;项目组首页</a></li>
	       </ul>
	       <ul class="nav navbar-nav navbar-right">
	         <li><a href="#basic"><i class="glyphicon glyphicon-user"></i>&nbsp;基本信息</a></li>
	         <li><a href="#paper"><i class="glyphicon glyphicon-book"></i>&nbsp;已发表文献</a></li>
	         <li><a href="#project"><i class="glyphicon glyphicon-tags"></i>&nbsp;科研项目</a></li>
	         <li><a href="#stuproject"><i class="glyphicon glyphicon-leaf"></i>&nbsp;学生项目</a></li>
	         <li><a href="#homework"><i class="glyphicon glyphicon-edit"></i>&nbsp;学生作业</a></li>
	         <li><a href="#contact"><i class="glyphicon glyphicon-envelope"></i>&nbsp;联系我</a></li>
	       </ul>
	     </div><!--/.nav-collapse -->
	   </div>
	 </nav>
	 
	 <div class="container-fluid" id="below-nav">
	 	<div class="row-fluid" id="basic">
			<div class="span12">
				<div class="jumbotron1">
					<!-- <h3 class="title-responsive">基本信息</h3> -->
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12" id="introductions">
								<p id="zh_introduction">
									<label class="label label-info" id="name"><i class="glyphicon glyphicon-user"></i>&nbsp;中文名</label>
									<!-- 男，1976-，于xxxx年就读于xxxx大学，xxxx年获得高级工程师职称，xxxx年xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
								</p>
								<p id="en_introduction">
									<label class="label label-info" id="en_name"><i class="glyphicon glyphicon-user"></i>&nbsp;name</label>&nbsp;&nbsp; 
									<!-- is interested in software testing theory, methods, empirical study, application and education. Especially we have made much work for combinatorial testing (CT), including many research papers, a web based assistant tool, a CT repository of almost all the published papers, a book in Chinese, a micro-teaching video et al. -->
								</p>
							</div>
							
							<div>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<!-- <li role="presentation" class="active"><a href="#detailinfo" aria-controls="detailinfo" role="tab" data-toggle="tab">详细介绍</a></li> -->
									<li role="presentation" class="active"><a href="#myexperience" aria-controls="myexperience" role="tab" data-toggle="tab">工作&经历</a></li>
									<li role="presentation"><a href="#myaward" aria-controls="myaward" role="tab" data-toggle="tab">荣誉</a></li>
									<li role="presentation"><a href="#mycourse" aria-controls="mycourse" role="tab" data-toggle="tab">教学课程</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<!-- <div role="tabpanel" class="tab-pane active" id="detailinfo">
										我的详细介绍
									</div> -->
									<div role="tabpanel" class="tab-pane active" id="myexperience">
										我的个人经历
									</div>
									<div role="tabpanel" class="tab-pane" id="myaward">
										我的荣誉
									</div>
									<div role="tabpanel" class="tab-pane" id="mycourse">
										我的教学课程
									</div>
								</div>
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
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row-fluid" id="project">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-tags"></i>&nbsp;科研项目</h3>
					
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
									<li class="span4">
										<div class="thumbnail1">
											<div class="caption">
												<h4>
													哈佛结构
												</h4>
												<p>
													哈佛结构是一种将程序指令存储和数据存储分开的存储器结构，它的主要特点是将程序和数据存储在不同的存储空间中，进行独立编址。
												</p>
												<p>
													<a class="btn btn-info btn-sm" href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;浏览</a>
												</p>
											</div>
										</div>
									</li>
									<li class="span4">
										<div class="thumbnail1">
											<div class="caption">
												<h4>
													改进型哈佛结构
												</h4>
												<p>
													改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。
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
		<div class="row-fluid" id="stuproject">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-leaf"></i>&nbsp;学生项目</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12">
								<ul class="thumbnails" id="ul_stuproj">
									<li class="span4">
										<div class="thumbnail">
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
									<li class="span4">
										<div class="thumbnail">
											<div class="caption">
												<h4>
													哈佛结构
												</h4>
												<p>
													哈佛结构是一种将程序指令存储和数据存储分开的存储器结构，它的主要特点是将程序和数据存储在不同的存储空间中，进行独立编址。
												</p>
												<p>
													<a class="btn btn-info btn-sm" href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;浏览</a>
												</p>
											</div>
										</div>
									</li>
									<li class="span4">
										<div class="thumbnail">
											<div class="caption">
												<h4>
													改进型哈佛结构
												</h4>
												<p>
													改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。
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
		<div class="row-fluid" id="homework">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-edit"></i>&nbsp;
						<a target="_blank" href="http://219.230.50.120/">学生作业&nbsp;<i class="glyphicon glyphicon-hand-left"></i>&nbsp;<small>点我进入“作业教学系统”</small></a>
					</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span4">
								<ul id="ul_homework1" class="ul_homework">
									<li>
										<a href="#">作业1[2015-10-05]</a>
									</li>
									<li>
										<a href="#">作业2[2015-10-04]</a>
									</li>
									<li>
										<a href="#">作业3[2015-10-03]</a>
									</li>
									<li>
										<a href="#">作业4[2015-10-02]</a>
									</li>
									<li>
										<a href="#">作业5[2015-10-01]</a>
									</li>
								</ul>
							</div>
							<div class="span4">
								<ul id="ul_homework2" class="ul_homework">
									<li>
										<a href="#">作业6[2015-09-05]</a>
									</li>
									<li>
										<a href="#">作业7[2015-09-04]</a>
									</li>
									<li>
										<a href="#">作业8[2015-09-03]</a>
									</li>
									<li>
										<a href="#">作业9[2015-09-02]</a>
									</li>
									<li>
										<a href="#">作业10[2015-09-01]</a>
									</li>
								</ul>
							</div>
							<div class="span4">
								<ul id="ul_homework3" class="ul_homework">
									<li>
										<a href="#">作业11[2015-08-05]</a>
									</li>
									<li>
										<a href="#">作业12[2015-08-04]</a>
									</li>
									<li>
										<a href="#">作业13[2015-08-03]</a>
									</li>
									<li>
										<a href="#">作业14[2015-08-02]</a>
									</li>
									<li>
										<a href="#">作业15[2015-08-01]</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="row-fluid footer" id="contact">
			<div class="span12">
				<div class="jumbotron1">
					<h3 class="title-responsive"><i class="glyphicon glyphicon-envelope"></i>&nbsp;联系我</h3>
					
					<div class="container-fluid">
						<div class="row-fluid">
							<div class="span12" style="text-align:center;">
								<address> 
									<strong id="person_name">徐家喜</strong><br /> 
									<span id="address">鹤琴楼 309室</span><br /> 
									<!-- <span id="">弘景大道3601号 南京晓庄学院,</span><br /> 
									<span id="">江宁,南京,江苏</span><br />  -->
									<!-- 邮编:<span id="zip">211171</span><br />  -->
									E-mail:<span id="email">xujiaxi@126.com</span>
								</address>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/bjsp/index/myindex.js"></script>
</body>
</html>