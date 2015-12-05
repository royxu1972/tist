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
	var homework_id = "";
	<% 
		String homework_id = "";
		if(request.getParameter("homework_id")!=null){
			homework_id = request.getParameter("homework_id").toString();
		}
	%>
	var homework_id = '<%=homework_id%>';
</script>
<title>作业详情</title>
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
						  <h1 id="homework_name" class="info">作业名称</h1>
						  
						  <div class="tabbable" id="tabs-628925">
							<ul class="nav nav-tabs">
								<li class="active">
									<a href="#panel-808950" data-toggle="tab">作业要求</a>
								</li>
								<li>
									<a href="#panel-853703" data-toggle="tab">附件下载</a>
								</li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="panel-808950">
									<dl class="dl-horizontal" style="margin-top:15px;">
										<dt>
											发布时间
										</dt>
										<dd id="edit_time" class="info">
											2015-10-01 22:30:12
										</dd>
										<dt>
											作业要求
										</dt>
										<dd id="homework_request" class="info">
											xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br/>
											xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br/>
											xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br/>
											xxxxxxxxxxxxxxxxxxxxxx<br/>
										</dd>
									</dl>
								</div>
								
								<div class="tab-pane" id="panel-853703">
									<div class="col-lg-12" id="course_files" style="margin-left:20px;">
									
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
			
			                        </div>
								</div>
							</div>
						</div>
						  <!--  -->
						  
						  <p>
						  	<dl class="dl-horizontal">
								
							</dl>
						  </p>
						  
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
function loadInfo(){
	$.ajax({
		type: "POST",
		data: {s_homework_id:homework_id},
		url: contextPath + '/findhomeworks.do',
		async : false,
		success: function(result) {
			//console.info(result);
			$("#course_files").empty();
			if(result.rows.length > 0){
				$(".info").empty();
				var row = result.rows[0];
				$("#homework_name").append(row.homework_name);
				$("#edit_time").append(row.edit_time);
				$("#homework_request").append(row.homework_request);
				if(valueIsNotEmpty(row.old_names)){
					var names = row.old_names.split(",");
					var paths = row.file_paths.split(",");
					var fileids = row.file_ids.split(",");
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
						$("#course_files").append(html);
					}
				}
			}else{
				$.messager.alert('提示信息：', '未查到信息', 'warning');
			}
		}
	});
}

$(function(){
	loadInfo();
});
</script>
</body>
</html>