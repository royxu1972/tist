//全局变量
var method;
var url;

function create(){
	//禁用自增id，不传回后台
	$('#increment_id').attr("disabled",false);
	//easyui清空表单的操作
	$("#data_form").form("clear");
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
	var random_id = date2str(new Date(),"yyyyMMddhhmmss")+randomNum(4);
	$('#increment_id').val(random_id);
	//保存方法,在BasicInfoController.java中
	url = contextPath + "/savebasicinfo.do";
	method = "POST";
	data_form._method.value="POST";
}

function edit(){
	//easyui清空表单的操作
	$("#data_form").form("clear");
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
//	$("#dialog_title").text("编辑基本信息");
//	var rows = $('#data_table').bootstrapTable('getSelections');
//	if(rows.length==1){
//		//解除自增id的禁用，传回后台
		$('#increment_id').attr("disabled",false);
//		//easyui载入选中行数据的方法
//		$("#data_form").form("load",rows[0]);
//		//显示bootstrap对话框
//		$('#dialog').modal('show');
//	}else{
//		//easyui的警告框
//		$.messager.alert('提示信息：', '请选择修改的记录！', 'warning');
//	}
	//修改方法,在BasicInfoController.java中
	url = contextPath+"/updatebasicinfo.do";
    method = "POST";
    data_form._method.value="POST";
}

function remove(){
	//bootstraptable获取所有选中行的方法
	var rows = $('#data_table').bootstrapTable('getSelections');
	//easyui清空表单的操作
	$("#data_form").form("clear");
	if(rows.length>0){
		$.messager.confirm('Confirm', '确定要删除?', function(r) {
			if (r) {
				//删除方法,在BasicInfoController.java中
				url = contextPath + "/deletebasicinfos.do";
				method = "POST";
				data_form._method.value="DELETE";
				for ( var i = 0; i < rows.length; i++) {
					$("#ids").append(
							"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].increment_id
									+ "\">");
					}
				$('#data_form').form('load', rows[0]);
				$('#submit').click();
			}
		});
		
	}else{
		$.messager.alert('提示信息：', '请选择要删除的记录!', 'warning');
	}
}

function loadBasicinfos(){
	$.ajax({
        type: "POST",
        url: contextPath + '/findbasicinfobysession.do',
        async : false,
        success: function(result) {
        	console.info(result);
        	if(result.success){
        		if(result.rows.length>0){
            		edit();
            		$("#data_form").form("load",result.rows[0]);
            		var row = result.rows[0];
            		if(valueIsNotEmpty(row.old_names)){
            			var pic_path = row.file_paths.substring(row.file_paths.indexOf(contextPath),row.file_paths.length);
            			$("#myphoto").attr("src",pic_path);
            		}
            		if(valueIsEmpty(row.member_site)){
            			$("#member_site").val("#");
            		}
            		if(valueIsNotEmpty(row.email) && (valueIsEmpty(row.email_validated) || row.email_validated == "未验证")){
            			$(".btn_valid").remove();
            			$("#div_email").append("<a onclick='openEmailValidateDialog();' style='margin-top:3px;' class='btn btn-sm btn-warning btn_valid'>验证邮箱</a>");
            		}else if(valueIsNotEmpty(row.email) && row.email_validated == "已验证"){
            			$("#lbl_email").text("(已验证)邮箱");
            		}
            	}else{
            		create();
            	}
        	}else{
        		$.messager.alert('提示信息：', result.msg, 'warning');
        		$("#data_form input").attr("disabled","disabled");
        		$("#data_form textarea").attr("disabled","disabled");
        	}
        	
        }
    });
}

function openEmailValidateDialog(){
	//打开对话框
	$('#dialog').modal('show');
	$("#btn_getvalidatecode").removeAttr("disabled");
	$("#my_email").val($("#email").val());
	$("#validate_code").val("");
}

//倒计时重新发送按钮
var countdown = 5;
function settime(val) {
	if (countdown == 0) {
		$("#btn_getvalidatecode").removeAttr("disabled");
		$("#btn_getvalidatecode").text("获取验证码");
		countdown = 5;
		return;
	} else {
		$("#btn_getvalidatecode").attr("disabled", true);
		$("#btn_getvalidatecode").text("重新发送(" + countdown + ")");
		countdown--;
	}
	setTimeout(function() {
		settime(val);
	}, 1000);
}

//向邮箱发送验证码
function getValidateCode() {
	var email = $("#my_email").val();
	var user_no = $("#increment_id").val();
	$.ajax({
        type: "POST",
        url: contextPath + '/saveemailrandom.do',
        data: {email: email, user_no: user_no},
        async : false,
        beforeSend: function(){
        	if(valueIsEmpty(email) || valueIsEmpty(user_no)){
        		$.messager.alert('出错了', "email或user_no获取失败", 'warning');
        		return false;
        	}else{
        		return true;
        	}
        },
        success: function(result) {
        	console.info(result);
        	if(result.success){
        		$.messager.alert('成功', "验证码已发送，请到您的邮箱查看", 'info');
        	}else{
        		$.messager.alert('发送失败：', result.msg, 'warning');
        	}
        	
        }
    });
}

/**
 * 验证我的Email
 */
function validateMyEmail() {
	var email = $("#my_email").val();
	var user_no = $("#increment_id").val();
	var random_code = $("#validate_code").val();
	$.ajax({
        type: "POST",
        url: contextPath + '/validateemail.do',
        data: {email: email, user_no: user_no, random_code: random_code},
        async : false,
        beforeSend: function(){
        	if(valueIsEmpty(email) || valueIsEmpty(user_no) || valueIsEmpty(random_code)){
        		$.messager.alert('出错了', "email或user_no获取失败或未输入验证密码", 'warning');
        		return false;
        	}else{
        		return true;
        	}
        },
        success: function(result) {
        	console.info(result);
        	if(result.success){
        		$.messager.alert('成功', "邮箱验证成功", 'info');
        		if(!result.is_validated){
        			$.messager.alert('成功', "更新邮箱验证状态失败", 'warning');
        		}else{
        			$(".btn_valid").remove();//移除邮箱验证按钮
            		$("#lbl_email").text("(已验证)邮箱");//设置标签为已验证
            		//如果单独验证邮箱，则要将隐藏的email_validated字段设置为已验证，否则在更新基本信息后邮箱又将置为未验证状态
            		$("#email_validated").val("已验证");
            		$("#dialog").modal("hide");
        		}
        	}else{
        		$.messager.alert('验证失败：', result.msg, 'warning');
        	}
        	
        }
    });
}

//图片预览
function preview(sender){
	PreviewImage(sender,"myphoto","divPreview");
}

$(function(){
	
	loadMyMenus();
	loadBasicinfos();
	
//	$('#summernote').summernote({
//        height: 400,
//        lang: 'zh-CN',
//        focus: true
//    });
	//百度editor
    var ue = UE.getEditor('summernote');
	
	$("textarea").each(function(){
		$(this).focus(function(){
			var title = $(this).attr("title");
			var id = $(this).attr("id");
			$("#summernote_confirm").attr("target_id",id);
//			$('#summernote').code($(this).val());
			//换成ueditor
			ue.setContent($(this).val());
			openSummerNote(title);
		});
	});
	
	$(".tool_buttons").each(function(){
//		为当前按钮绑定点击事件
		$(this).unbind('click').bind('click', function(){
//			获取当前按钮的iconCls的值，根据值来判断用户点击了什么按钮
			var btn_id=$(this).attr("id");
			if(btn_id=="create"){
				create();
			}else if(btn_id=="edit"){
				edit();
			}else if(btn_id=="remove"){
				remove();
			}else if(btn_id=="summernote_confirm"){
				getContent();
			}
		});
	});
	
	$('#submit').click(function() {
		
		validateForm();//在paper_validate.js中
		if($("#data_form").valid()){//表单验证成功后提交
			var all_files = $("input[name='files']");
			var ids = "";
			for(var i=0;i<all_files.length;i++){
				if (ids != '') ids += ',';
				ids += $(all_files[i]).attr("id");
			}
			var array_ids = ids.split(",");
			$.ajaxFileUpload({
				secureuri:false,
		        fileElementId:array_ids,
		        dataType:'json',
				type : "POST",
				data : $("#data_form").serializeArray(),
				url : url,
				success : function(result) {
					try {
						if (result.success) {
							//easyui清空表单
							$("#data_form").form("clear");
							//清空验证状态(于public/js/public.js中)
							removeValidate("#data_form");
							$.messager.show({
								title : '提示信息：',
								msg : "修改成功!"
							});
							loadBasicinfos();
						}
					} catch (e) {
						$.messager.show({
							title : '提示信息：',
							msg : "操作失败！" + e
						});
					}
				},
//					如果请求失败，服务器端报错500时执行该方法
				error : function(result) {
					$.messager.show({
						title : '提示信息：',
						msg : result.msg+";[type:"+method+";data:"+$("#data_form").serialize()+";url:"+url+"]"
					});
				}
			});
		}
		
//		$.ajax({
//			type : "POST",
//			data : $("#data_form").serialize(),
//			url : url,
//			beforeSend:function(){
//				validateForm();//在basicinfo_validate.js中
//		        return $("#data_form").valid();
//		    },
//			success : function(result) {
//				try {
//					if (result.success) {
////							以下代码清空所有操作
////						$("#dialog").modal("hide");
//						//重载bootstraptable
////						$('#data_table').bootstrapTable("refresh");
////						$('#data_table').bootstrapTable("uncheckAll");
//						//easyui清空表单
////						$("#data_form").form("clear");
//						//清空验证状态(于public/js/public.js中)
//						removeValidate("#data_form");
//						$.messager.show({
//							title : '提示信息：',
//							msg : "操作成功!"
//						});
//						//清空ids中的所有元素
//						$("#ids").empty();
//						loadBasicinfos();
//					}
//				} catch (e) {
//					$.messager.show({
//						title : '提示信息：',
//						msg : "操作失败！" + e
//					});
//				}
//			},
////				如果请求失败，服务器端报错500时执行该方法
//			error : function(result) {
//				$.messager.show({
//					title : '提示信息：',
//					msg : result.msg+";[type:"+method+";data:"+$("#data_form").serialize()+";url:"+url+"]"
//				});
//			}
//		});
	});
});