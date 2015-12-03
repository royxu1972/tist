/**
 * 修改人：梁轰
 * 修改原因：增加判断js变量是否为空的方法
 * 修改时间：2014年9月27日14:32:34
 * @param value	传入的变量的值
 * @returns {Boolean}	返回true or false
 */
function valueIsNotEmpty(value) {
//	默认返回为false
	var result = false;
	if (value != null && value != "" && value != undefined) {
		result = true;
	}else{
		result = false;
	}
	return result;
}

function valueIsEmpty(value) {
//	默认返回为false
	var result = false;
	if (value == null || value == "" || value == undefined) {
		result = true;
	}else{
		result = false;
	}
	return result;
}

/*
 * 清空表单的验证状态
 */
function removeValidate(form_id){
	$(form_id+" > .form-group").removeClass("has-error");
	$("span.error").remove();
}

/*
 * 打开富文本编辑对话框
 */
function openSummerNote(title){
	if(valueIsEmpty(title)){
		title = "文本内容";
	}
	//设置对话框标题
	$("#summer_title").text("编辑——"+title);
	//打开对话框
	$('#summer_dialog').modal('show');
}

//获取富文本内容
//function getContent(){
//	var target_id = $("#summernote_confirm").attr("target_id");
//	var content = $('#summernote').code();
//	$("#"+target_id).val(content);
//	$("#summer_dialog").modal("hide");
//}

//获ueditor取富文本内容
function getContent(){
	//百度editor
    var ue = UE.getEditor('summernote');
	var target_id = $("#summernote_confirm").attr("target_id");
//	var content = $('#summernote').code();
	var content = ue.getContent();
	$("#"+target_id).val(content);
	$("#summer_dialog").modal("hide");
}

/**
 * @param n 生成n为随机数
 * @returns {String}
 */
function randomNum(n){ 
    var t=''; 
    for(var i=0;i<n;i++){ 
        t+=Math.floor(Math.random()*10); 
    } 
    return t; 
} 

/**
 * @param x 日期
 * @param y 格式
 * @returns 
 */
function date2str(x, y) {
	var z = {
		M : x.getMonth() + 1,
		d : x.getDate(),
		h : x.getHours(),
		m : x.getMinutes(),
		s : x.getSeconds()
	};
	y = y.replace(/(M+|d+|h+|m+|s+)/g, function(v) {
		return ((v.length > 1 ? "0" : "") + eval('z.' + v.slice(-1))).slice(-2)
	});
	return y.replace(/(y+)/g, function(v) {
		return x.getFullYear().toString().slice(-v.length)
	});
}

/**
 * @param fileObj <input type="file">的value
 * @param imgPreviewId 预览图片img标签的id
 * @param divPreviewId 预览图片img标签外面的div的id
 * @returns {String}
 */
function PreviewImage(fileObj, imgPreviewId, divPreviewId) {
    var allowExtention = ".jpg,.bmp,.gif,.png"; //允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
    var extention = fileObj.value.substring(fileObj.value.lastIndexOf(".") + 1).toLowerCase();
    var browserVersion = window.navigator.userAgent.toUpperCase();
    if (allowExtention.indexOf(extention) > -1) {
        if (fileObj.files) {//HTML5实现预览，兼容chrome、火狐7+等
            if (window.FileReader) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
                }
                reader.readAsDataURL(fileObj.files[0]);
            } else if (browserVersion.indexOf("SAFARI") > -1) {
                alert("不支持Safari6.0以下浏览器的图片预览!");
            }
        } else if (browserVersion.indexOf("MSIE") > -1) {
            if (browserVersion.indexOf("MSIE 6") > -1) {//ie6
                document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
            } else {//ie[7-9]
                fileObj.select();
                if (browserVersion.indexOf("MSIE 9") > -1)
                    fileObj.blur(); //不加上document.selection.createRange().text在ie9会拒绝访问
                var newPreview = document.getElementById(divPreviewId + "New");
                if (newPreview == null) {
                    newPreview = document.createElement("div");
                    newPreview.setAttribute("id", divPreviewId + "New");
                    newPreview.style.width = document.getElementById(imgPreviewId).width + "px";
                    newPreview.style.height = document.getElementById(imgPreviewId).height + "px";
                    newPreview.style.border = "solid 1px #d2e2e2";
                }
                newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                var tempDivPreview = document.getElementById(divPreviewId);
                tempDivPreview.parentNode.insertBefore(newPreview, tempDivPreview);
                tempDivPreview.style.display = "none";
            }
        } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
            var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
            if (firefoxVersion < 7) {//firefox7以下版本
                document.getElementById(imgPreviewId).setAttribute("src", fileObj.files[0].getAsDataURL());
            } else {//firefox7.0+                    
                document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(fileObj.files[0]));
            }
        } else {
            document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
        }
    } else {
        alert("仅支持" + allowExtention + "为后缀名的文件!");
        fileObj.value = ""; //清空选中文件
        if (browserVersion.indexOf("MSIE") > -1) {
            fileObj.select();
            document.selection.clear();
        }
        fileObj.outerHTML = fileObj.outerHTML;
    }
    return fileObj.value;    //返回路径
}

/**
 * 加载Session中的菜单
 * 缺点：定制化很强
 */
function loadMyMenus(){
	$.ajax({
		type : "POST",
		url : contextPath + '/getmenusbysession.do',
		cache : false,
		async:false,
		dataType : 'json',
		success : function(r) {
			if (r.success == true) {
				if(valueIsEmpty(r.parentMenus)){
					$.messager.alert("抱歉！","您无访问此系统的权限，请联系管理员分配权限","warning");
					$("#top_right_menu").append("<li><a href='"+contextPath+"/logout.do"+"'><i class='glyphicon glyphicon-log-out'></i>&nbsp;退出系统</a></li>");
				}else{
					var childMenus = r.childMenus;
//					console.info($("#top_menus"));
					$("#top_menus").empty();
					$("#top_right_menu").empty();
					$.each(r.parentMenus,function(idx,item) {
						var contentHtml = "";
						if(item.menu_name == "我的主页"){
							contentHtml = "<li><a href='"+contextPath + item.href+"'>"+item.menu_name+"</a></li>";
//							console.info(contentHtml);
							$("#top_menus").append(contentHtml);
						}else if(item.menu_name == "修改密码"){
							contentHtml = "<li><a href='"+contextPath + item.href+"'><i class='glyphicon glyphicon-lock'></i>&nbsp;"+item.menu_name+"</a></li>";
//							console.info(contentHtml);
							$("#top_right_menu").append(contentHtml);
						}else{
							contentHtml = 	"<li class='dropdown'>"+
												"<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>"+item.menu_name+"&nbsp;<span class='caret'></span></a>"+
												"<ul class='dropdown-menu'>";
							for(var i=0;i<childMenus.length;i++){
								if(childMenus[i].father_id == item.menu_id){
									if(childMenus[i].href != "#" && valueIsNotEmpty(childMenus[i].href)){
										actionname = childMenus[i].href;
						//							console.info(actionname+"\t"+childMenus[i].menu_name);
									}else{
										actionname ="/jsp/error/404.jsp";
									}
									if(actionname.indexOf("paper.jsp")>0){
										contentHtml += "<li role='separator' class='divider'></li>";
									}
									if(item.menu_name == "系统功能"){
										contentHtml+="<li><a target='_blank' href='"+contextPath + actionname+"'>"+childMenus[i].menu_name+"</a></li>";
									}else{
										contentHtml+="<li><a href='"+contextPath + actionname+"'>"+childMenus[i].menu_name+"</a></li>";
									}
									
									
								}
							}
							contentHtml += 		"</ul>"+
											"</li>";
//							console.info(contentHtml);
							$("#top_menus").append(contentHtml);
//							console.info("after append");
						}
						
					});
					
					$("#top_right_menu").append("<li><a href='"+contextPath+"/logout.do"+"'><i class='glyphicon glyphicon-log-out'></i>&nbsp;退出系统</a></li>");
				}
			} else{
				$.messager.show({
					title : '提示',
					msg : r.msg
					});
			}
		}
	});
}
