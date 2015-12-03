/**
 * 加载省信息
 * @returns 执行成功加载省信息到combobox
 * @author Jelon
 * @createtime 2014年5月5日 19:05:05
 */

function loadPovcinceCode() {
    //清空市、区combobox
    $('#city').combobox('clear');
    $('#area').combobox('clear');

    //ajax从数据库加载省编码
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/provinceinfo.do',
        dataType: 'json',
        success: function(result) {
            $('#province').combobox({
                data: result.rows,
                valueField: 'provinceID',
                textField: 'province',
                width : 120,
                onSelect: function(record) {
                    //刷新数据，重新读取省份下的城市，并清空当前输入的值
                    loadCityCode(record.provinceID);
                    var id = (record.provinceID).substring(0, 1); //按省查站点名称只要省编码前两位
                    loadSationCode(id); //生成对应的站点名称
                }
            }).combobox('clear');
        }
    });
}

/**
 * 通过省编码加载市信息
 * @param provinceID 省编码
 * @returns 执行成功加载市信息到combobox
 * @author Jelon
 * @createtime 2014年5月5日 19:05:05
 */

function loadCityCode(provinceID) {
    //清空区combobox
    $('#area').combobox('clear');

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/cityinfo.do?provinceid=' + provinceID,
        dataType: 'json',
        success: function(result) {
            $('#city').combobox({
                data: result.rows,
                valueField: 'cityID',
                textField: 'city',
                width : 100,
                onSelect: function(record) {
                    loadAreaCode(record.cityID);
                    var id = (record.cityID).substring(0, 3); //按省查站点名称只要省编码前两位
                    loadSationCode(id); //生成对应的站点名称
                }
            }).combobox('clear');
        }
    });
}

/**
 * 通过市编码加载区信息
 * @param cityID 市编码
 * @returns 执行成功加载区信息到combobox
 * @author Jelon
 * @createtime 2014年5月5日 19:05:05
 */

function loadAreaCode(cityID) {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/areainfo.do?cityid=' + cityID,
        dataType: 'json',
        async: false,
        success: function(result) {
            $('#area').combobox({
                data: result.rows,
                valueField: 'areaID',
                textField: 'area',
                width : 100,
                onSelect: function(record) {
                    loadSationCode(record.areaID);

                }
            }).combobox('clear');
        }
    });
}

/**
 * 通过区编码加载站点信息
 * @param{}areaID 这个areaID可以是省的前两位，也可以是市的前四位，也可以是县的六位
 * @returns 执行成功加载站点名称信息到combobox
 * @author roy xu
 * @createtime 2014年5月6日 
 */

function loadSationCode(areaID) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: contextPath + '/findstationbyareaid.do?areaid=' + areaID,
        dataType: 'json',
        async: true,
        success: function(result) {
            $('#station').combobox({
                data: result.rows,
                width : 120,
                valueField: 'station_id',
                textField: 'station_name',
                onSelect: function(record) {
					loadUserCode(record.station_id);
                }
            }).combobox('clear');
        }
    });
}

/**
 * 
 * @param serviceTypeIds 如“27;28”
 * @returns {String} 如对应的27和28的服务形式“面询;广场咨询”
 */
function transferServiceType(serviceTypeIds){
	var json_service_type = "";//用于保存数据库中的所有服务形式
	var service_type_ids;//数组，保存传入的服务形式id
	var service_type_names = "";//用于返回服务形式的字符串
	var load_result = false;//用于保存载入服务形式的成功与失败
	if(serviceTypeIds == null || serviceTypeIds == ""){
		alert("传入的serviceTypeIds为空");
	}else{
//		将serviceTypeIds由“;”分号为间隔符分开到数组service_type_ids中
		service_type_ids = serviceTypeIds.split(";");
		$.ajax({ 
			type : "POST", 
			contentType : "application/json",  
			url : contextPath+'/loadservicetype.do',
			dataType : 'json', 
			async: false, 
			success : function(result) {
//				将后台数据库中的服务形式JSON存到json_service_type中
				json_service_type = result.rows;
				load_result = true;
			},
			error : function(result) {
				load_result = false;
				
			}
		});
		if(load_result){
//			遍历service_type_ids数组中拥有的服务形式的个数
			for(var i=0;i<service_type_ids.length;i++){
//				遍历所有的服务形式，相同则取该id对应的服务形式
				for(var j=0;j<json_service_type.length;j++){
					if(service_type_ids[i] == json_service_type[j].id){
						service_type_names += json_service_type[j].o_colum+";";
					}
				}
			}
			service_type_names = service_type_names.substring(0,service_type_names.length-1);
		}else{
			service_type_names = serviceTypeIds;
			alert("载入数据库的服务形式失败");
		}

	}
	console.info("返回的服务形式："+service_type_names);
	return service_type_names;
}

/**
 * 
 * @param serviceObjectIds 如“35;36”
 * @returns {String} 如对应的35和36的服务对象“幼儿;小学生”
 */
function transferServiceObject(serviceObjecIds){
	var json_service_object = "";//用于保存数据库中的所有服务对象
	var service_object_ids;//数组，保存传入的服务对象id
	var service_object_names = "";//用于返回服务对象的字符串
	var load_result = false;//用于保存载入服务对象的成功与失败
	alert(contextPath);
	if(serviceObjecIds == null || serviceObjecIds == ""){
		alert("传入的serviceObjecIds为空");
	}else{
//		将serviceTypeIds由“;”分号为间隔符分开到数组service_object_ids中
		service_object_ids = serviceObjecIds.split(";");
		$.ajax({ 
			type : "POST", 
			contentType : "application/json",  
			url : contextPath+'/loadserviceobject.do',
			dataType : 'json', 
			async: true, 
			success : function(result) {
//				将后台数据库中的服务对象JSON存到json_service_object中
				json_service_object = result.rows;
				load_result = true;
			},
			error : function(result) {
				load_result = false;
			}
		});
		if(load_result){
//			遍历service_object_ids数组中拥有的服务对象的个数
			for(var i=0;i<service_object_ids.length;i++){
//				遍历所有的服务对象，相同则取该id对应的服务对象
				for(var j=0;j<json_service_object.length;j++){
					if(service_object_ids[i] == json_service_object[j].id){
						service_object_names += json_service_object[j].o_colum+";";
					}
				}
			}
//			去掉最后一个分号
			service_object_names = service_object_names.substring(0,service_object_names.length-1);
		}else{
			service_object_names = serviceObjecIds;
				alert(contextPath);
			alert("载入数据库的服务对象失败");
		}

	}
	console.info("返回的服务对象："+service_object_names);
	return service_object_names;
}

/**
 * 通过站点编码加载用户信息
 * @param areaID 市编码
 * @returns 执行成功加载用户名称信息到combobox
 * @author wxz
 * @createtime 2014年8月22日 
 */
function loadUserCode(station_id){
	$.ajax({ 
		type : "POST", 
		contentType : "application/json",  
		url : contextPath+'/finduserbystationid.do?station_id='+station_id,
		dataType : 'json', 
		async: false, 
		success : function(result) { 
			 $('#userid').combobox({
			        width : 120,
			        data:result.rows,
			        valueField:'user_id',
			        textField:'person_name'
			 }).combobox('clear');
		}
	});
}

/**
 * 修改人：梁轰
 * 修改原因：增加判断js变量是否为空的方法
 * 修改时间：2014年9月27日14:32:34
 * @param value	传入的变量的值
 * @returns {Boolean}	返回true or false
 */
function valueIsNotEmpty(value) {
//	默认返回为false
	var result = false;
	if (value != null && value != "" && value != undefined) {
		result = true;
	}else{
		result = false;
	}
	return result;
}

function valueIsEmpty(value) {
//	默认返回为false
	var result = false;
	if (value == null || value == "" || value == undefined) {
		result = true;
	}else{
		result = false;
	}
	return result;
}