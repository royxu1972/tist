function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
			"proj_name" : {
				required : true
			}, 
			"proj_origin" : {
				required : true
			}, 
			"start_date" : {
				required : true
			}, 
			"end_date" : {
				required : true
			}, 
			"proj_fund" : {
				required : true
			}, 
			"my_work" : {
				required : true
			}, 
			"proj_info" : {
				required : true
			}
		},
		
		messages : {
			"proj_name" : {
				required : "必填"
			}, 
			"proj_origin" : {
				required : "必填"
			}, 
			"start_date" : {
				required : "必填"
			}, 
			"end_date" : {
				required : "必填"
			}, 
			"proj_fund" : {
				required : "必填"
			}, 
			"my_work" : {
				required : "必填"
			}, 
			"proj_info" : {
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