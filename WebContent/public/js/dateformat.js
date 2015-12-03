

function formatDatebox(value) {
        if (value == null || value == '') {
            return '';
        }
    var dt;
    if (value instanceof Date) {
        dt = value;
    }
    else {
        dt = new Date(value);
        if (isNaN(dt)) {
            value = value.replace(/\/Date\((-?\d+)\)\//, '$1'); 
            dt = new Date();
            dt.setTime(value);
        }
    }
    return dt.formatDate("yyyy-MM-dd-hh");  
}



Date.prototype.formatDate = function (format) //author: meizz   
	{  
	    var o = {  
	        "M+": this.getMonth() + 1, //month   
	        "d+": this.getDate(),    //day   
	        "h+": this.getHours(),   //hour   
	        "m+": this.getMinutes(), //minute   
	        "s+": this.getSeconds(), //second   
	        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter   
	        "S": this.getMilliseconds() //millisecond   
	    };  
	    if (/(y+)/.test(format)) 
	    	format = format.replace(RegExp.$1,  
	    			(this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    for (var k in o) 
	    	if (new RegExp("(" + k + ")").test(format))  
	        format = format.replace(RegExp.$1,  
	        		RegExp.$1.length == 1 ? o[k] :  
	        ("00" + o[k]).substr(("" + o[k]).length));  
	    return format;  
	}  

$('#fm').datebox.defaults.formatter = function(date){ 
	 var y = date.getFullYear(); 
	 var m = date.getMonth()+1; 
	 var d = date.getDate(); 
	 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d); 
 }; 


