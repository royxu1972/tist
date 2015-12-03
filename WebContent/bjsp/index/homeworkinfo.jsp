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
						<div class="jumbotron">
						  <h1 id="homework_name" class="info">作业名称</h1>
						  
						  <p>
						  	<dl class="dl-horizontal">
								<dt>
									最后修改时间
								</dt>
								<dd id="edit_time" class="info">
									2015-10-01 22:30:12
								</dd>
								<dt>
									作业要求
								</dt>
								<dd id="homework_request" class="info" style="border:1px solid #000000;">
									xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br/>
									xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br/>
									xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<br/>
									xxxxxxxxxxxxxxxxxxxxxx<br/>
								</dd>
								<dt>
									作业附件下载
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
		data: {s_homework_id:homework_id},
		url: contextPath + '/findhomeworks.do',
		async : false,
		success: function(result) {
			//console.info(result);
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