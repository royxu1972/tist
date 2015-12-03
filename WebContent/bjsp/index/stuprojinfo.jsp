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
	var stu_proj_id = "";
	<% 
		String stu_proj_id = "";
		if(request.getParameter("stu_proj_id")!=null){
			stu_proj_id = request.getParameter("stu_proj_id").toString();
		}
	%>
	var stu_proj_id = '<%=stu_proj_id%>';
</script>
<title>学生项目详情</title>
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
						  <h1 id="stu_proj_name" class="info">学生项目名称</h1>
						  
						  <p>
						  	<dl class="dl-horizontal">
								<dt>
									项目负责人
								</dt>
								<dd id="main_students" class="info">
									季啸,何映蝶
								</dd>
								<dt>
									其他成员
								</dt>
								<dd id="proj_members" class="info">
									梁轰,袁春雷,黄会,袁春雷
								</dd>
								<dt>
									指导老师
								</dt>
								<dd id="teachers" class="info">
									王江平,徐家喜
								</dd>
								<dt>
									项目级别
								</dt>
								<dd id="stu_proj_rank" class="info">
									省级
								</dd>
								<dt>
									项目类型
								</dt>
								<dd id="stu_proj_type" class="info">
									大学生创新项目
								</dd>
								<dt>
									项目成果
								</dt>
								<dd id="proj_results" class="info">
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
		data: {s_stu_proj_id:stu_proj_id},
		url: contextPath + '/findstudentprojects.do',
		async : false,
		success: function(result) {
			//console.info(result);
			if(result.rows.length > 0){
				$(".info").empty();
				var row = result.rows[0];
				$("#stu_proj_name").append(row.stu_proj_name);
				$("#main_students").append(row.main_students);
				$("#proj_members").append(row.proj_members);
				$("#teachers").append(row.teachers);
				$("#stu_proj_rank").append(row.stu_proj_rank);
				$("#stu_proj_type").append(row.stu_proj_type);
				$("#proj_results").append(row.proj_results);
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