/**jquery和easyui扩展方法**/;
var rspjs=$.extend({},rspjs);

/*扩展easyui的dategrid，使其支持my97日期*/
$.extend($.fn.datagrid.defaults.editors, {
	my97 : {/* 扩展my97日期时间控件在datagrid编辑器中使用 */
		init : function(container, options) {
			var input = $('<input class="Wdate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm:ss\',readOnly:true});"  />').appendTo(container);
			return input;
		},
		getValue : function(target) {
			return $(target).val();
		},
		setValue : function(target, value) {
			$(target).val(value);
		},
		resize : function(target, width) {
			var input = $(target);
			if ($.boxModel == true) {
				input.width(width - (input.outerWidth() - input.width()));
			} else {
				input.width(width);
			}
		}
	}
});

/*把以逗号分隔的数据转化成数值*/
rspjs.arrayStr = function(value) {
	if (value) {
		var values = [];
		var t = value.split(',');
		for ( var i = 0; i < t.length; i++) {
			values.push('' + t[i]);
		}
		return values;
	} else {
		return [];
	}
};

/*jquery 日期格式化*/
Date.prototype.formatDate = function (format){  
    var o = {  
        "M+": this.getMonth() + 1, //month  
        "d+": this.getDate(),    //day  
        "h+": this.getHours(),   //hour  
        "m+": this.getMinutes(), //minute  
        "s+": this.getSeconds(), //second  
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter  
        "S": this.getMilliseconds() //millisecond  
    }  
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,  
    (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    for (var k in o) if (new RegExp("(" + k + ")").test(format))  
        format = format.replace(RegExp.$1,  
      RegExp.$1.length == 1 ? o[k] :  
        ("00" + o[k]).substr(("" + o[k]).length));  
    return format;  
}
