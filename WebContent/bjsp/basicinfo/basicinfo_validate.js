function validateForm(){
	var validator=$("#data_form").validate({
		ignore: "", // 开启hidden验证， 1.9版本后默认关闭
		
		rules : {
			"name" : {
				required : true
			}, 
			"en_name" : {
				required : true
			}, 
			"gender" : {
				required : true
			}, 
			"birthday" : {
				required : true
			}, 
			"academic" : {
				required : true
			}, 
			"pro_title" : {
				required : true
			}, 
			"email" : {
				required : true
			}, 
			"address" : {
				required : true
			}, 
			"zh_introduction" : {
				required : true
			}, 
			"en_introduction" : {
				required : true
			}, 
			"detail_introduction" : {
				required : true
			}, 
			"research_area" : {
				required : true
			}, 
			"member_role" : {
				required : true
			}
		},
		
		messages : {
			"name" : {
				required : "必填"
			}, 
			"en_name" : {
				required : "必填"
			}, 
			"gender" : {
				required : "必填"
			}, 
			"birthday" : {
				required : "必填"
			}, 
			"academic" : {
				required : "必填"
			}, 
			"pro_title" : {
				required : "必填"
			}, 
			"email" : {
				required : "必填"
			}, 
			"address" : {
				required : "必填"
			}, 
			"zh_introduction" : {
				required : "必填"
			}, 
			"en_introduction" : {
				required : "必填"
			}, 
			"detail_introduction" : {
				required : "必填"
			}, 
			"research_area" : {
				required : "必填"
			}, 
			"member_role" : {
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