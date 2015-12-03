function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
			"user_name" : {
				required : true
			},
			"user_password" : {
				required : true
			}
		},
		
		messages : {
			"user_name" : {
				required : "必填"
			},
			"user_password" : {
				required : "必填"
			}
		},
		
		validClass:"checked", 
		errorClass : "error",
		errorElement : "span",
		errorPlacement : function(error, element) {
			element.parent().parent().addClass("has-error");
		    error.appendTo(element.parent());
		},  
		success: function(label) {
			label.parent().parent().removeClass("has-error");
			label.remove();
        }
	});
}