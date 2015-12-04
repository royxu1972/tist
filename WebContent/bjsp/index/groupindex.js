/**
 * 查询项目组信息
 */
function loadGroupinfos(){
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/listallprojectgroups.do',
        dataType: 'json',
        async : false,
        success: function(result) {
//        	console.info(result);
        	if(result.success){
        		if(result.rows.length>0){
//            		$("#data_form").form("load",result.rows[0]);
//            		$("#group_zhname").append(result.rows[0].group_zhname);
//            		$("#group_enname").append(result.rows[0].group_enname);
            		$("#group_zhinfo").append(result.rows[0].group_zhintro);
//            		$("#group_eninfo").append(result.rows[0].group_enintro);
            	}else{
//            		create();
            	}
        	}else{
        		
        	}
        	
        }
    });
}
/**
 * 查询项目组成员信息
 */
function loadGroupMembers(){
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/findbasicinfos.do',
        dataType: 'json',
        async : false,
        success: function(result) {
        	console.info(result);
        	if(result.success){
        		if(result.rows.length>0){
        			$("#teachers").empty();
        			$.each(result.rows,function(idx,item){
        				var pic_path = contextPath + "/bjsp/basicinfo/man128.png";
        				var research_area = "暂无";
        				var pro_title = "暂无";
        				var teach_courses = "暂无";
        				var member_role = "暂无";
        				var member_site = contextPath + "/bjsp/index/myindex.jsp?id="+item.increment_id;
        				
        				if(valueIsNotEmpty(item.file_paths)){
        					pic_path = item.file_paths.substring(item.file_paths.indexOf(contextPath),item.file_paths.length);
        				}
        				if(valueIsNotEmpty(item.research_area)){
        					research_area = item.research_area;
        				}
        				if(valueIsNotEmpty(item.pro_title)){
        					pro_title = item.pro_title;
        				}
        				if(valueIsNotEmpty(item.teach_courses)){
        					teach_courses = item.teach_courses;
        				}
        				if(valueIsNotEmpty(item.member_role)){
        					member_role = item.member_role;
        				}
        				var html = 	"<div class='col-lg-4 animated flipInX'>" +
        								"<div class='contact-box'>" +
        									"<a target='_blank' href='"+member_site+"'>" +
	        									"<div class='col-sm-4'>" +
	        										"<div class='text-center'>" +
	        											"<img alt='image' style='width:76px;height:76px;' class='img-circle m-t-xs img-responsive' src='"+pic_path+"' />" +
														"<div class='m-t-xs font-bold'>"+member_role+"</div>" +
													"</div>" +
												"</div>" +
												"<div class='col-sm-8'>" +
													"<h4><strong>"+item.name+"</strong></h4>" +
													"<p>"+pro_title+"</p>" +
													"<p><strong>研究方向:</strong></p>" +
													"<p>"+research_area+"</p>" +
													"<p><strong>教学课程:</strong></p>" +
													"<p>"+teach_courses+"</p>" +
												"</div>" +
												"<div class='clearfix'></div>" +
											"</a>" +
										"</div>" +
									"</div>";
        				$("#teachers").append(html);
        			});
            	}else{
//            		create();
            	}
        	}else{
        		
        	}
        	
        }
    });
}

/**
 * 查询通知消息
 */
function loadPagedNotices(){
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/listpagednotices.do?offset=0&limit=3',
        dataType: 'json',
        async : false,
        success: function(result) {
        	if(result.success){
        		$("#ul_messages").empty();
        		if(result.rows.length>0){
            		$.each(result.rows,function(idx,item){
//            			var html = 	"<li>" +
//            							"<div>" +
//	            							"<small>"+item.notice_time+"</small>" +
//	            							"<h4>"+item.notice_title+"</h4>" +
//	            							"<p>"+item.notice_content+"</p>" +
//	            							"<a href='#'><i class='fa fa-trash-o'></i></a>" +
//            							"</div>" +
//            						"</li>";
            			var html = 	"<li class='animated fadeInRight'>" +
										"<div class='dropdown-messages-box'>" +
											"<div class='media-body'>" +
//												"<small class='pull-right'>"+item.notice_time+"</small>" +
												"<p style='text-align: center;margin-bottom:3px;'>" +
													"<strong>"+item.notice_title+"</strong><br/>" +
													"<small><b>"+item.notice_time+"</b></small>" +
												"</p>" +
												"<p style='text-indent:2em;'>"+item.notice_content+"</p>" +
											"</div>" +
										"</div>" +
									"</li>" +
									"<li class='divider'></li>";
            			$("#ul_messages").append(html);
            		});
            	}else{
            		
            	}
        	}else{
        		
        	}
        }
    });
}

/**
 * 加载“已发表文献”
 */
function loadPapers(){
	$.ajax({
		type: "POST",
		url: contextPath + '/findpapers.do',
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
 * 加载“科研项目”
 */
function loadScienceProjects(){
	$.ajax({
        type: "POST",
        url: contextPath + '/listscienceprojects.do',
        data: {page: 1,rows: 9},
        async : false,
        success: function(result) {
        	$("#ul_proj").empty();
        	for(var i=0;i<result.rows.length;i++){
				var html = 	"<li class='span4 animated fadeInRight'>" +
								"<div class='thumbnail1'>" +
									"<div class='caption'>" +
										"<h4>" + result.rows[i].proj_name + "</h4>" +
										"<p>" + result.rows[i].proj_info + "</p>" +
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

$(function(){
	loadGroupinfos();
	loadGroupMembers();
	loadPagedNotices();
	loadPapers();
	loadScienceProjects();
});