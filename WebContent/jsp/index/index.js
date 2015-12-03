function addTab(title, url){
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);//选中并刷新
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != '主页') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	} else {
		var content = createFrame(url);
		$('#tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
	tabClose();
}
function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}
		
function tabClose() {
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}		
//绑定右键菜单事件
function tabCloseEven() {
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != '主页') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t != '主页') {
				$('#tabs').tabs('close',t);
			}
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();		
		if(prevall.length>0){
			prevall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
				if(t != '主页') {
					$('#tabs').tabs('close',t);
				}
			});
		}
		if(nextall.length>0) {
			nextall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
				if(t != '主页') {
					$('#tabs').tabs('close',t);
				}
			});
		}
		return false;
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

/*
 * 从服务器动态加载左侧可折叠菜单
 */
function loadAccordion() {
	$.ajax({
		type : "POST",
		url : contextPath + '/getmenusbysession.do',
		cache : false,
		async:false,
		dataType : 'json',
		success : function(r) {
			if (r.success == true) {
				if(valueIsEmpty(r.parentMenus)){
					$.messager.alert("抱歉！","您无访问此系统的权限，请联系管理员分配权限","warning");
				}else{
					var childMenus = r.childMenus;
					$.each(r.parentMenus,function(idx,item) {
						var contentHtml="";
						for(var i=0;i<childMenus.length;i++){
							if(childMenus[i].father_id == item.menu_id){
								if(childMenus[i].href != "#" && valueIsNotEmpty(childMenus[i].href)){
									actionname = childMenus[i].href;
//												console.info(actionname+"\t"+childMenus[i].menu_name);
								}else{
									actionname ="/jsp/error/404.jsp";
								}
								contentHtml+='<a href="javascript:void(0);" src="'+contextPath + actionname+'" class="cs-navi-tab">'+childMenus[i].menu_name+'</a><br/>';
//											console.info(contentHtml);
							}
						}
						$('#left_accordion').accordion('add',{
							title:item.menu_name,
							content:contentHtml
						});
					});
				}
			} else{
				$.messager.show({
					title : '提示',
					msg : r.msg
					});
			}
		}
	});
}

function tabLoadEvent(){
	$('.cs-navi-tab').click(function() {
		var $this = $(this);
		var href = $this.attr('src');
		var title = $this.text();
		addTab(title, href);
	});
}

function getUser_id(){
	$.ajax({ 
		type : "POST", 
//		contentType : "application/json",  
		url : contextPath+'/getuserid.do',//写在Train_levelController里
		dataType : 'text', 
		async: false, 
		success : function(result) {
//			alert(result);
			if(result!=""&&result!=null){
				$("#s1").val(result);
			}else{
				$("#s1").val("未登录");
			}
		},
		error : function(result) {
			$.messager.show({
				title : '提示信息：',
				msg : result
			});
		}
	});
}

$(function() {
	loadAccordion();
	tabCloseEven();
	tabLoadEvent();
//	getUser_id();
});
