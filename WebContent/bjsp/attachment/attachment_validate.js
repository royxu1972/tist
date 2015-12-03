function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
						"attachment_id" : {
				required : true
			}, 
			"table_of_attachment" : {
				required : true
			}, 
			"related_id" : {
				required : true
			}, 
			"original_name" : {
				required : true
			}, 
			"new_name" : {
				required : true
			}, 
			"file_type" : {
				required : true
			}, 
			"file_path" : {
				required : true
			}, 
			"del_flag" : {
				required : true
			}
		},
		
		messages : {
			"attachment_id" : {
				required : "必填"
			}, 
			"table_of_attachment" : {
				required : "必填"
			}, 
			"related_id" : {
				required : "必填"
			}, 
			"original_name" : {
				required : "必填"
			}, 
			"new_name" : {
				required : "必填"
			}, 
			"file_type" : {
				required : "必填"
			}, 
			"file_path" : {
				required : "必填"
			}, 
			"del_flag" : {
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