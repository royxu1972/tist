<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/public/jsp/bootstrapInc.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bjsp/index/index.css" />
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
						<div class="jumbotron">
						  <h1 id="proj_name" class="info">项目名称</h1>
						  
						  <p>
						  	<dl class="dl-horizontal">
								<dt>
									开始日期
								</dt>
								<dd id="start_date" class="info">
									2014-10-01
								</dd>
								<dt>
									结束日期
								</dt>
								<dd id="end_date" class="info">
									2015-10-01
								</dd>
								<dt>
									支持资金
								</dt>
								<dd id="proj_fund" class="info">
									江苏省教育厅
								</dd>
								<dt>
									我承担的工作
								</dt>
								<dd id="my_work" class="info">
									主持
								</dd>
								<dt>
									项目简介
								</dt>
								<dd id="proj_info" class="info">
									xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz
									xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
								</dd>
								<dt>
									项目附件下载
								</dt>
								<dd id="file_list" class="info">
									卡地亚拥有150多年历史，是法国珠宝金银首饰的制造名家。
								</dd>
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
		data: {s_proj_id:proj_id},
		url: contextPath + '/findscienceprojects.do',
		async : false,
		success: function(result) {
			//console.info(result);
			if(result.rows.length > 0){
				$(".info").empty();
				var row = result.rows[0];
				$("#proj_name").append(row.proj_name);
				$("#start_date").append(row.start_date);
				$("#end_date").append(row.end_date);
				$("#proj_fund").append(row.proj_fund);
				$("#my_work").append(row.my_work);
				$("#proj_info").append(row.proj_info);
				if(valueIsNotEmpty(row.old_names)){
					var names = row.old_names.split(",");
					var paths = row.file_paths.split(",");
					var fileids = row.file_ids.split(",");
					for(var i=0;i<names.length;i++){
						var current_name = names[i];
						var new_name = paths[i].substring(paths[i].indexOf("/attachment/")+12,paths[i].length);
						var file_id = fileids[i];
//						console.info("current_name="+current_name+"\n"+"current_path="+new_name);
						var file_link = "<div id='cur_file_"+i+"'>" +
											"<a target='_blank' href='"+contextPath+"/download.do?file_name="+new_name+"&old_name="+current_name+"'>"+current_name+"</a>" +
											"&nbsp;&nbsp;" +
										"</div>";
						$("#file_list").append(file_link);
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