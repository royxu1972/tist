function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
			"stu_proj_name" : {
				required : true
			}, 
			"stu_proj_type" : {
				required : true
			}, 
			"stu_proj_rank" : {
				required : true
			}, 
			"main_students" : {
				required : true
			}, 
			"proj_members" : {
				required : true
			}, 
			"teachers" : {
				required : true
			}, 
			"proj_results" : {
				required : true
			}
		},
		
		messages : {
			"stu_proj_name" : {
				required : "必填"
			}, 
			"stu_proj_type" : {
				required : "必填"
			}, 
			"stu_proj_rank" : {
				required : "必填"
			}, 
			"main_students" : {
				required : "必填"
			}, 
			"proj_members" : {
				required : "必填"
			}, 
			"teachers" : {
				required : "必填"
			}, 
			"proj_results" : {
				required : "必填"
			}
		},
		
		validClass:"checked", 
		errorClass : "error",
		errorElement : "span",
		errorPlacement : function(error, element) {
			//给bootstrap表单中class为form-group的div增加has-error的样式，整行变红
			element.parent().parent().addClass("has-error");
		    //验证元素的后面追加如“必填”的验证提示
		    error.appendTo(element.parent());
		},  
		success: function(label) {
			//删除bootstrap表单中class为form-group的div的has-error，恢复成正常表单状态
			label.parent().parent().removeClass("has-error");
			//删除验证元素的后面追加的如“必填”的验证提示
			label.remove();
        }
	});
}