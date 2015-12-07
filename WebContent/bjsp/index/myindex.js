/**
 * 加载“已发表文献”
 */
function loadAllPapers(){
	$.ajax({
		type: "POST",
		url: contextPath + '/findpapers.do',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
			$("#ol_paper").empty();
			for(var i=0;i<result.rows.length;i++){
				var paper_href = "#";
        		if(valueIsNotEmpty(result.rows[i].file_paths)){
        			var new_name = result.rows[i].file_paths.substring(result.rows[i].file_paths.indexOf("/attachment/")+12,result.rows[i].file_paths.length);
        			paper_href = contextPath+"/download.do?file_name="+new_name+"&old_name="+result.rows[i].old_names;
        		}
//        		console.info(paper_href);
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
		url: contextPath + '/findstudentprojects.do',
		data:{s_user_no : id},
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
											"<a target='_blank' class='btn btn-info btn-sm' href='"+contextPath+"/bjsp/index/stuprojinfo.jsp?stu_proj_id="+result.rows[i].stu_proj_id+"'>" +
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
        url: contextPath + '/findscienceprojects.do',
        data:{s_user_no : id},
        async : false,
        success: function(result) {
        	$("#ul_proj").empty();
        	for(var i=0;i<result.rows.length;i++){
        		var proj_info = result.rows[i].proj_info;
            	
            	if(valueIsNotEmpty(proj_info)){
            		proj_info = proj_info.replace("/<[^>]+>/g","");
            		if(proj_info.length > 45) proj_info = proj_info.substring(0,45)+"...";
            	}
				var html = 	"<li class='span4'>" +
								"<div class='thumbnail1'>" +
									"<div class='caption'>" +
										"<h4 style='min-height:40px;'>" + result.rows[i].proj_name + "</h4>" +
										"<p>" + proj_info + "</p>" +
										"<p>" +
											"<a target='_blank' class='btn btn-info btn-sm' href='"+contextPath+"/bjsp/index/scienceprojectinfo.jsp?proj_id="+result.rows[i].proj_id+"'>" +
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
 * 加载“个人经历”
 */
function loadExperiences(){
	$.ajax({
		type: "POST",
		url: contextPath + '/findexperiences.do',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
//			console.info(result);
			if(result.success){
				if(result.total > 0){
					$("#myexperience").empty();
					var html = "<ol>";
					$.each(result.rows,function(idx,item){
						var time = item.time_period_start+"至"+item.time_period_end;
						html += "<li>" +
									time + "&nbsp;&nbsp;&nbsp;&nbsp;" +
									item.experience_info + "&nbsp;&nbsp;(" +
									item.experience_role + ");" +
								"</li>";
					});
					html += "</ol>";
					$("#myexperience").append(html);
				}
			}else{
				
			}
		}
	});
}

/**
 * 加载“个人荣誉”
 */
function loadAwards(){
	$.ajax({
		type: "POST",
		url: contextPath + '/findawards.do',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
//			console.info(result);
			if(result.success){
				if(result.total > 0){
					$("#myaward").empty();
					var html = "<ol>";
					$.each(result.rows,function(idx,item){
						var time = item.award_date;
						html += "<li>" +
									time + "&nbsp;&nbsp;&nbsp;&nbsp;" +
									item.award_name + "&nbsp;&nbsp;(" +
									item.award_unit + ");" +
								"</li>";
					});
					html += "</ol>";
					$("#myaward").append(html);
				}
			}else{
				
			}
		}
	});
}

/**
 * 加载“教学课程”
 */
function loadCourses(){
	$.ajax({
		type: "POST",
		url: contextPath + '/findcourses.do',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
//			console.info(result);
			if(result.success){
				if(result.total > 0){
					$("#mycourse").empty();
					var html = "<ol>";
					$.each(result.rows,function(idx,item){
						var href = contextPath+"/bjsp/index/courseinfo.jsp?id="+item.course_id;
						html += "<li>" +
									"<a target='_blank' href='"+href+"'>" + item.course_name + "</a>"+
								"</li>";
					});
					html += "</ol>";
					$("#mycourse").append(html);
				}
			}else{
				
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
		url: contextPath + '/listpagedhomeworks2.do?offset=0&limit=5',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
			$("#ul_homework1").empty();
			for(var i=0;i<result.rows.length;i++){
				var html = 	"<li>" +
								"<a target='_blank' href='"+contextPath+"/bjsp/index/homeworkinfo.jsp?homework_id="+result.rows[i].homework_id+"'>" +
									result.rows[i].homework_name+ "&nbsp;["+result.rows[i].create_time.substring(0,result.rows[i].create_time.indexOf(" "))+"]" +
								"</a>" +
							"</li>";
				$("#ul_homework1").append(html);
			}
		}
	});
	$.ajax({
		type: "GET",
		url: contextPath + '/listpagedhomeworks2.do?offset=5&limit=5',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
			$("#ul_homework2").empty();
			for(var i=0;i<result.rows.length;i++){
				var html = 	"<li>" +
								"<a target='_blank' href='"+contextPath+"/bjsp/index/homeworkinfo.jsp?homework_id="+result.rows[i].homework_id+"'>" +
									result.rows[i].homework_name+ "&nbsp;["+result.rows[i].create_time.substring(0,result.rows[i].create_time.indexOf(" "))+"]" +
								"</a>" +
							"</li>";
				$("#ul_homework2").append(html);
			}
		}
	});
	$.ajax({
		type: "GET",
		url: contextPath + '/listpagedhomeworks2.do?offset=10&limit=5',
		data:{s_user_no : id},
		async : false,
		success: function(result) {
			$("#ul_homework3").empty();
			for(var i=0;i<result.rows.length;i++){
				var html = 	"<li>" +
								"<a target='_blank' href='"+contextPath+"/bjsp/index/homeworkinfo.jsp?homework_id="+result.rows[i].homework_id+"'>" +
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
        url: contextPath + '/findbasicinfos.do',
        data:{s_increment_id : id},
        async : false,
        success: function(result) {
//        	console.info(result);
        	if(result.rows.length>0){
//        		$("#data_form").form("load",result.rows[0]);
        		var zh_introduction = result.rows[0].zh_introduction;
        		var en_introduction = result.rows[0].en_introduction;
//        		var zh_introduction = result.rows[0].zh_introduction.replace(/<[^>]+>/g,"");
//        		var en_introduction = result.rows[0].en_introduction.replace(/<[^>]+>/g,"");
//        		console.info(zh_introduction);
//        		console.info(en_introduction);
        		$("#zh_introduction").append(zh_introduction);
        		$("#en_introduction").append(en_introduction);
        		$("#name").empty();
        		$("#en_name").empty();
        		$("#detailinfo").empty();
        		var name = "中文名";
        		var en_name = "Name";
        		var address = "地址暂无";
        		var email = "暂无";
        		var detail_introduction = "暂无";
        		if(valueIsNotEmpty(result.rows[0].name)){
        			name = result.rows[0].name;
        		}
        		if(valueIsNotEmpty(result.rows[0].en_name)){
        			en_name = result.rows[0].en_name;
        		}
        		if(valueIsNotEmpty(result.rows[0].email)){
        			email = result.rows[0].email;
        		}
        		if(valueIsNotEmpty(result.rows[0].address)){
        			address = result.rows[0].address;
        		}
        		if(valueIsNotEmpty(result.rows[0].detail_introduction)){
        			detail_introduction = result.rows[0].detail_introduction;
        		}
        		$("#name").append("<i class='glyphicon glyphicon-user'></i>&nbsp;"+name);
        		$("#en_name").append("<i class='glyphicon glyphicon-user'></i>&nbsp;"+en_name);
        		$("#person_name").text(name+"("+en_name+")");
        		$("#address").text(address);
        		$("#email").text(email);
//        		$("#detailinfo").append(detail_introduction);
        		
        	}else{
//        		create();
        	}
        }
    });
}

$(function(){
	if(valueIsNotEmpty(id)){
		loadBasicinfos();
		loadExperiences();
		loadAwards();
		loadCourses();
		loadAllPapers();
		loadAllStudentProjects();
		loadAllScienceProjects();
		loadAllHomeworks();
	}else{
		$.messager.alert("警告","无效的访问！","warning");
	}
	
});