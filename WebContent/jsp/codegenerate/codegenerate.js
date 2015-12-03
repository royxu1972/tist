$(function(){
	$("#generate_jspjs").prop("checked",true);
	
	$('#submit').click(function() {
		var checked = $("#generate_jspjs").prop("checked");
		var ckeck_value = "1";
		if(checked){
			ckeck_value = "1";
		}else{
			ckeck_value = "0";
		}
		
		var left_right_checked = $("#left_right").prop("checked");
		var left_right_ckeck_value = "1";
		if(left_right_checked){
			left_right_ckeck_value = "1";
		}else{
			left_right_ckeck_value = "0";
		}
		
		$.ajax({
			type : "POST",
			data : $("#form").serialize(),
			url : contextPath + "/generate.do?generate_jspjs="+ckeck_value+"&left_right="+left_right_ckeck_value,
//			提交前的操作，在这个方法内可以对表单进行验证（前台验证），如果返回为false，则该请求不会送到后台
			beforeSend:function(){
//				console.info($("#form").serialize());
//				console.info(contextPath + "/generate.do?generate_jspjs="+ckeck_value+"&left_right="+left_right_ckeck_value);
//				console.info($("#form").form("validate"));
				return $("#form").form("validate");
		    },
			success : function(result) {
				console.info(result);
				try {
					if (result.success) {
//						$("#get_set").val(result.field_generate);
						$("#module_generate").val(result.module_generate);
//						$("#form_code").val(result.form_code);
//						$("#field_js").val(result.field_js);
						alert("操作成功");
					}else{
						alert("失败");
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
	});
});