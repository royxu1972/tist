function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
			"course_name" : {
				required : true
			}, 
			"course_grades" : {
				required : true
			}, 
			"course_length" : {
				required : true
			}
		},
		
		messages : {
			"course_name" : {
				required : "必填"
			}, 
			"course_grades" : {
				required : "必填"
			}, 
			"course_length" : {
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