function loadCourseInfo(){
	$.ajax({
		type: "POST",
		data: {s_course_id : id},
		url: contextPath + '/findcourses.do',
		async : false,
		success: function(result) {
			//console.info(result);
			$("#course_files").empty();
			if(result.rows.length > 0){
				$(".info").empty();
				var row = result.rows[0];
//				console.info(row);
				var course_intro = "暂无简介";
				var course_outline = "暂无大纲";
				if(valueIsNotEmpty(row.course_intro)){
					course_intro = row.course_intro;
				}
				if(valueIsNotEmpty(row.course_outline)){
					course_outline = row.course_outline;
				}
				$("#course_name").append(row.course_name);
				$("#introduction").append(course_intro);
				$("#outline").append(course_outline);
				if(valueIsNotEmpty(row.old_names)){
					var names = row.old_names.split(",");
					var paths = row.file_paths.split(",");
//					var fileids = row.file_ids.split(",");
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
	if(valueIsNotEmpty(id)){
		loadCourseInfo();
	}else{
		$.messager.alert("警告","无效的访问！","warning");
	}
	
});