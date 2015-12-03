//全局变量
var method;
var url;
var file_i = 1;

function create(){
	//禁用自增id，不传回后台
	$('#increment_id').attr("disabled","disabled");
	//设置对话框标题
	$("#dialog_title").text("新增科研项目");
	//打开对话框
	$('#dialog').modal('show');
	//easyui清空表单的操作
	$("#data_form").form("clear");
	initFileUpload();
	initFileList();
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
	$('#increment_id').attr("disabled",false);
	var random_id = date2str(new Date(),"yyyyMMddhhmmss")+randomNum(4);
	$('#increment_id').val(random_id);
	//保存方法,在ScienceProjectController.java中
	url = contextPath + "/savescienceproject.do";
	method = "POST";
	data_form._method.value="POST";
}

function edit(){
	//easyui清空表单的操作
	$("#data_form").form("clear");
	//清空验证状态(于public/js/public.js中)
	removeValidate("#data_form");
	$("#dialog_title").text("编辑科研项目");
	var rows = $('#data_table').bootstrapTable('getSelections');
	if(rows.length==1){
		//解除自增id的禁用，传回后台
		$('#increment_id').attr("disabled",false);
		initFileUpload();
		initFileList();
		//easyui载入选中行数据的方法
		$("#data_form").form("load",rows[0]);
		if(valueIsNotEmpty(rows[0].old_names)){
			var names = rows[0].old_names.split(",");
			var paths = rows[0].file_paths.split(",");
			var fileids = rows[0].file_ids.split(",");
			for(var i=0;i<names.length;i++){
				var current_name = names[i];
				var new_name = paths[i].substring(paths[i].indexOf("/attachment/")+12,paths[i].length);
				var file_id = fileids[i];
//				console.info("current_name="+current_name+"\n"+"current_path="+new_name);
				var file_link = "<div id='cur_file_"+i+"'>" +
									"<a target='_blank' href='"+contextPath+"/download.do?file_name="+new_name+"&old_name="+current_name+"'>"+current_name+"</a>" +
									"&nbsp;&nbsp;" +
									"<a href='#' onclick='removeFile(\""+file_id+"\",\""+rows[0].proj_id+"\",\"cur_file_"+i+"\",\""+paths[i]+"\");'><i class='glyphicon glyphicon-trash'></i>&nbsp;删除附件</a>" +
								"</div>";
				$("#file_list").append(file_link);
			}
		}
		//显示bootstrap对话框
		$('#dialog').modal('show');
	}else{
		//easyui的警告框
		$.messager.alert('提示信息：', '请选择修改的记录！', 'warning');
	}
	//修改方法,在ScienceProjectController.java中
	url = contextPath+"/updatescienceproject.do";
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
				//删除方法,在ScienceProjectController.java中
				url = contextPath + "/deletescienceprojects.do";
				method = "POST";
				data_form._method.value="DELETE";
				for ( var i = 0; i < rows.length; i++) {
					$("#ids").append(
							"<input type=\"hidden\" name=\"ids\" value=\"" + rows[i].proj_id
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

/**
 * 根据file_id删除文件
 * @param file_id
 */
function removeFileUpload(file_id){
//	console.info("#div_file_"+file_id);
	$("#div_file_"+file_id).remove();
}

/**
 * 增加一个文件
 * "<input name='files' id='file_"+file_i+"' class='easyui-filebox' style='width:250px;' buttonText='选择文件'/>" +
 */
function addFileUpload(){
	var file_html = "<div class='form-group file_divs' id='div_file_"+file_i+"'>" +
				    	"<label for='support_fund' class='col-sm-3 control-label'>文件</label>"+
				    	"<div class='col-sm-9'>"+
				    		"<input id='file_"+file_i+"' name='files' type='file'/>" +
				    		"<button class='btn btn-info btn-sm' onclick='removeFileUpload("+file_i+");'>" +
			    				"<i class='glyphicon glyphicon-trash'></i>&nbsp;删除附件" +
		    				"</button>" +
				    	"</div>"+
				    "</div>";
	$("#data_form").append(file_html);
	file_i = file_i + 1;
}

/**
 * 初始化上传表单控件
 */
function initFileUpload(){
	$(".file_divs").remove();
	file_i = 1;
}

/**
 * 初始化文件列表
 */
function initFileList(){
	$("#file_list").empty();
}

function removeFile(file_id,related_id,cur_file_i,path){
//	alert(file_id+"\t"+notice_id);
	if(valueIsNotEmpty(file_id)&&valueIsNotEmpty(related_id)){
		$.ajax({
			type : "POST",
			data : {attachment_id:file_id,related_id:related_id,file_path:path,table_of_attachment:"roy_science_project"},
			url : contextPath+"/deleteattachmentbyrelatedid.do",
			success : function(result) {
				try {
					if (result.success) {
						$("#"+cur_file_i).remove();
						$.messager.show({
							title : '提示信息：',
							msg : "删除成功"
						});
					}
				} catch (e) {
					$.messager.show({
						title : '提示信息：',
						msg : "操作失败！" + e
					});
				}
			},
//			如果请求失败，服务器端报错500时执行该方法
			error : function(result) {
				$.messager.show({
					title : '提示信息：',
					msg : result.msg+";[type:"+$method+";data:"+$("#form").serialize()+";url:"+$url+"]"
				});
			}
		});
	}else{
		$.messager.show({
			title : '提示信息：',
			msg :'删除失败'
		});
	}
}

$(function(){
	
	loadMyMenus();
	
	$('#data_table').bootstrapTable({
	    method: 'GET',
	    url: contextPath+'/listpagedscienceprojects.do',//分页查询,在ScienceProjectController.java中
	    cache: false,
	    height: 450,
	    striped: true,
	    pagination: true,
	    sidePagination:'server',//分页必须加上是server分页还是client分页
	    pageSize: 10,
	    pageList: [10, 25, 50, 100, 200],
	    toolbarAlign: 'left',
	    searchAlign: 'right',
	    toolbar: '#table_toolbar',
	    showColumns: true,
	    showRefresh: true,
	    showToggle: true,
//	    smartDisplay: false,
	    minimumCountColumns: 2,
	    clickToSelect: true,
	    idField: "proj_id",
	    columns: [
		    {
		        field: 'state',
		        checkbox: true
		    }, 
			{
				field : 'proj_name',
				title : '项目名称',
				align : 'center'
			}, 
			{
				field : 'proj_origin',
				title : '项目来源',
				align : 'center'
			}, 
			{
				field : 'start_date',
				title : '开始日期',
				align : 'center'
			}, 
			{
				field : 'end_date',
				title : '结束日期',
				align : 'center'
			}, 
			{
				field : 'proj_fund',
				title : '项目经费',
				align : 'center'
			}, 
			{
				field : 'my_work',
				title : '我承担的工作',
				align : 'center'
			}, 
			{
				field : 'proj_info',
				title : '项目介绍',
				align : 'center'
			}
	    
	    ],
	    onLoadSuccess: function(data){
	    	$('#data_table').bootstrapTable("uncheckAll");
	    }
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
//								以下代码清空所有操作
							$("#dialog").modal("hide");
							//重载bootstraptable
							$('#data_table').bootstrapTable("refresh");
							$('#data_table').bootstrapTable("uncheckAll");
							//清空ids中的所有元素
							$("#ids").empty();
							//easyui清空表单
							$("#data_form").form("clear");
							//清空验证状态(于public/js/public.js中)
							removeValidate("#data_form");
							$.messager.show({
								title : '提示信息：',
								msg : "操作成功!"
							});
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
		
	});
});