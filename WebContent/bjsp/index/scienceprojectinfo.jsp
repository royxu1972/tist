<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/index.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/filemanager.css" />
<style type="text/css">
.jumbotron {
	width: 70%;
	margin-left: auto;
	margin-right: auto;
	padding-left: 10px;
	padding-right: 10px;
}
</style>
<script type="text/javascript">
	var proj_id = "";
	<% 
		String proj_id = "";
		if(request.getParameter("proj_id")!=null){
			proj_id = request.getParameter("proj_id").toString();
		}
	%>
	var proj_id = '<%=proj_id%>';
</script>
<title>科研项目详情</title>
</head>
<body>

	<!-- 引入公共头部菜单 -->
	<jsp:include page="/public/jsp/infopagehead.jsp"></jsp:include>

	<div class="container-fluid" id="below-nav">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						<div style="width:80%;margin-left:auto;margin-right:auto;">
							<h1 id="proj_name" class="info">项目名称</h1>
							
							<div class="tabbable" id="tabs-628925">
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#panel-808950" data-toggle="tab">基本信息</a>
									</li>
									<li>
										<a href="#panel-853703" data-toggle="tab">附件下载</a>
									</li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="panel-808950">
											<dl class="dl-horizontal" style="margin-top:15px;">
												<dt>开始日期</dt>
												<dd id="start_date" class="info">2014-10-01</dd>
												<dt>结束日期</dt>
												<dd id="end_date" class="info">2015-10-01</dd>
												<dt>支持资金</dt>
												<dd id="proj_fund" class="info">江苏省教育厅</dd>
												<dt>承担工作</dt>
												<dd id="my_work" class="info">主持</dd>
												<dt>项目简介</dt>
												<dd id="proj_info" class="info" style="width:60%;">
													xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz
													xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
												</dd>
											</dl>
									</div>
									<div class="tab-pane" id="panel-853703">
										<div id="file_list" class="row info" style="margin-left:20px;"></div>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	function loadInfo() {
		$.ajax({
			type : "POST",
			data : {
				s_proj_id : proj_id
			},
			url : contextPath + '/findscienceprojects.do',
			async : false,
			success : function(result) {
				//console.info(result);
				if (result.rows.length > 0) {
					$(".info").empty();
					var row = result.rows[0];
					$("#proj_name").append(row.proj_name);
					$("#start_date").append(row.start_date);
					$("#end_date").append(row.end_date);
					$("#proj_fund").append(row.proj_fund);
					$("#my_work").append(row.my_work);
					$("#proj_info").append(row.proj_info);
					if (valueIsNotEmpty(row.old_names)) {
						var names = row.old_names.split(",");
						var paths = row.file_paths.split(",");
//						var fileids = row.file_ids.split(",");
						for(var i=0;i<names.length;i++){
							var current_name = names[i];
							var new_name = paths[i].substring(paths[i].indexOf("/attachment/")+12,paths[i].length);
							var href = contextPath+"/download.do?file_name="+new_name+"&old_name="+encodeURI(encodeURI(current_name));
							var img = "xls96.png";
							if(new_name.indexOf("doc")>0) img = "word96.png";
							if(new_name.indexOf("xls")>0) img = "xls96.png";
							if(new_name.indexOf("ppt")>0) img = "ppt96.png";
							var html = 	"<div class='file-box'>" +
											"<div class='file'>" +
												"<a target='_blank' href='" + href + "'>" +
													"<span class='corner'></span>" +
													"<div class='image'>" +
														"<img alt='image' class='img-responsive' src='imgs/"+img+"' style='margin-left:auto;margin-right:auto;'>" +
													"</div>" +
													"<div class='file-name'>" +
														current_name+"<br>" +
													"</div>" +
												"</a>" +
											"</div>" +
										"</div>";
							$("#file_list").append(html);
						}
					}
				} else {
					$.messager.alert('提示信息：', '未查到信息', 'warning');
				}
			}
		});
	}

	$(function() {
		loadInfo();
	});
</script>
</body>
</html>