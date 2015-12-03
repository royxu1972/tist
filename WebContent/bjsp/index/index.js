/**
 * 加载“已发表文献”
 */
function loadAllPapers(){
	$.ajax({
		type: "POST",
		url: contextPath + '/listallpapers.do',
		async : false,
		success: function(result) {
			$("#ol_paper").empty();
			for(var i=0;i<result.rows.length;i++){
				var paper_href = "#";
        		if(valueIsNotEmpty(result.rows[i].file_paths)){
        			var new_name = result.rows[i].file_paths.substring(result.rows[i].file_paths.indexOf("/attachment/")+12,result.rows[i].file_paths.length);
        			paper_href = contextPath+"/download.do?file_name="+new_name+"&old_name="+result.rows[i].old_names;
        		}
        		console.info(paper_href);
				var html = 	"<li>" +
								result.rows[i].author + ",<a href='"+paper_href+"'>" + result.rows[i].title + "</a>," +
								result.rows[i].journal + "," + result.rows[i].publish_time + "&nbsp;" +
							"</li>";
				$("#ol_paper").append(html);
			}
		}
	});
}

/**
 * 加载“学生项目”
 */
function loadAllStudentProjects(){
	$.ajax({
		type: "POST",
		url: contextPath + '/listallstudentprojects.do',
		async : false,
		success: function(result) {
			$("#ul_stuproj").empty();
        	for(var i=0;i<result.rows.length;i++){
				var html = 	"<li class='span4'>" +
								"<div class='thumbnail'>" +
									"<div class='caption'>" +
										"<h4>" + result.rows[i].stu_proj_name + "</h4>" +
										"<p>负责人:" + result.rows[i].main_students + "<br/>其他成员:" + result.rows[i].proj_members + "</p>" +
										"<p>" +
											"<a class='btn btn-info btn-sm' href='"+contextPath+"/bjsp/index/stuprojinfo.jsp?stu_proj_id="+result.rows[i].stu_proj_id+"'>" +
												"<i class='glyphicon glyphicon-eye-open'></i>&nbsp;浏览" +
											"</a>" +
										"</p>" +
									"</div>" +
								"</div>" +
							"</li>";
				$("#ul_stuproj").append(html);
        	}
		}
	});
}

/**
 * 加载“科研项目”
 */
function loadAllScienceProjects(){
	$.ajax({
        type: "POST",
        url: contextPath + '/listallscienceprojects.do',
        async : false,
        success: function(result) {
        	$("#ul_proj").empty();
        	for(var i=0;i<result.rows.length;i++){
				var html = 	"<li class='span4'>" +
								"<div class='thumbnail1'>" +
									"<div class='caption'>" +
										"<h4>" + result.rows[i].proj_name + "</h4>" +
										"<p>" + result.rows[i].proj_info + "</p>" +
										"<p>" +
											"<a class='btn btn-info btn-sm' href='"+contextPath+"/bjsp/index/scienceprojectinfo.jsp?proj_id="+result.rows[i].proj_id+"'>" +
												"<i class='glyphicon glyphicon-eye-open'></i>&nbsp;浏览" +
											"</a>" +
										"</p>" +
									"</div>" +
								"</div>" +
							"</li>";
				$("#ul_proj").append(html);
			}
        }
    });
}

/**
 * 加载“学生作业”
 */
function loadAllHomeworks(){
	$.ajax({
		type: "GET",
		url: contextPath + '/listpagedhomeworks.do?offset=0&limit=5',
		async : false,
		success: function(result) {
			$("#ul_homework1").empty();
			for(var i=0;i<result.rows.length;i++){
				var html = 	"<li>" +
								"<a href='"+contextPath+"/bjsp/index/homeworkinfo.jsp?homework_id="+result.rows[i].homework_id+"'>" +
									result.rows[i].homework_name+ "&nbsp;["+result.rows[i].create_time.substring(0,result.rows[i].create_time.indexOf(" "))+"]" +
								"</a>" +
							"</li>";
				$("#ul_homework1").append(html);
			}
		}
	});
	$.ajax({
		type: "GET",
		url: contextPath + '/listpagedhomeworks.do?offset=5&limit=5',
		async : false,
		success: function(result) {
			$("#ul_homework2").empty();
			for(var i=0;i<result.rows.length;i++){
				var html = 	"<li>" +
								"<a href='#'>" +
									result.rows[i].homework_name+ "&nbsp;["+result.rows[i].create_time.substring(0,result.rows[i].create_time.indexOf(" "))+"]" +
								"</a>" +
							"</li>";
				$("#ul_homework2").append(html);
			}
		}
	});
	$.ajax({
		type: "GET",
		url: contextPath + '/listpagedhomeworks.do?offset=10&limit=5',
		async : false,
		success: function(result) {
			$("#ul_homework3").empty();
			for(var i=0;i<result.rows.length;i++){
				var html = 	"<li>" +
								"<a href='#'>" +
									result.rows[i].homework_name+ "&nbsp;["+result.rows[i].create_time.substring(0,result.rows[i].create_time.indexOf(" "))+"]" +
								"</a>" +
							"</li>";
				$("#ul_homework3").append(html);
			}
		}
	});
}

function loadBasicinfos(){
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/listallbasicinfos.do',
        dataType: 'json',
        async : false,
        success: function(result) {
//        	console.info(result);
        	if(result.rows.length>0){
//        		$("#data_form").form("load",result.rows[0]);
        		$("#zh_introduction").append(result.rows[0].zh_introduction);
        		$("#en_introduction").append(result.rows[0].en_introduction);
        	}else{
//        		create();
        	}
        }
    });
}

$(function(){
	loadBasicinfos();
	loadAllPapers();
	loadAllStudentProjects();
	loadAllScienceProjects();
	loadAllHomeworks();
});