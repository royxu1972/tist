<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/menu/menu.js"></script>
<title>菜单管理</title>
</head>
<body class="easyui-layout" fit="true" border="false">
	<div data-options="region:'west',title:'系统菜单',split:false" style="width:30%;">
		<ul id="menu_tree" class="easyui-tree">
		
		</ul>
	</div>
	
    <div data-options="region:'east',split:false" style="width:70%;">
    
    	<div class="easyui-layout" style="width:100%;height:100%;">   
		    
		    <div data-options="region:'north',title:'操作',split:false" style="height:60px;width:100%;">
		    	<div class="datagrid-toolbar">
					<table cellpadding="0" cellspacing="0" style="width: 100%">
						<tr>
							<td>
							 	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
							</td>
						</tr>
					</table>
				</div>
		    </div>
		    
		    <div data-options="region:'center',title:'菜单详情'" style="padding:5px;">
		    	<form id="form" method="post" novalidate class="ui-form">
					<div style="display:none;">
						menu_id<input name="menu_id" id="increment_id" />
						del_flag<input name="del_flag" id="del_flag" />
						menu_level<input name="menu_level" id="menu_level" />
						create_by<input name="create_by" id="create_by" />
						create_time<input name="create_time" id="create_time" />
						father_id<input name="father_id" id="father_id" />
					</div>
					<fieldset id="bansic_info">
						<div class="ui-form-item">
							<label for="father_menu" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>父项菜单</label>
							<input id="father_menu" class="easyui-textbox" required="true" missingMessage="必须选一个父菜单">
						</div>
						
						<div class="ui-form-item">
							<label for="menu_name" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>菜单名称</label>
							<input name="menu_name" id="menu_name" class="easyui-textbox" />
						</div>
						
						<div class="ui-form-item">
							<label for="href" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>菜单链接</label>
							<input name="href" id="href" class="easyui-textbox" />
						</div>
						
						<div class="ui-form-item">
							<label for="sort" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>菜单顺序</label>
							<input name="sort" id="sort" class="easyui-textbox" />
						</div>
						
						<div class="ui-form-item">
							<label for="note" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>备注</label>
							<textarea rows="4" style="width:50%;" name="note" id="note"></textarea>
						</div>
						
						<br/>
						
						<div class="ui-form-item2 fn-left">
							<label for="update_by" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>最后修改人</label>
							<input name="update_by" id="update_by" class="easyui-textbox" data-options="readonly:true" />
						</div>
						
						<div class="ui-form-item2 fn-right">
							<label for="update_time" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>最后修改时间</label>
							<input name="update_time" id="update_time" class="easyui-textbox" data-options="readonly:true" />
						</div>
						
					</fieldset>
					
					<div id="ids"></div>
				</form>
				
				<div id="dlg-buttons">
					<a href="#" class="easyui-linkbutton" id="submit" iconCls="icon-ok">确定</a> 
					<a href="#" class="easyui-linkbutton" id="cancel" iconCls="icon-cancel" onclick="javascript:$('#form').form('clear')">清空</a>
				</div>
		    </div>
		     
		</div>  
		
    </div>
    
    <div id="dialog" class="easyui-dialog"
		style="width:350px; height: 450px;" closed="true"
		modal="true" maximizable="true" resizable="true" buttons="#buttons">
		
		<ul id="select_menu" class="easyui-tree">
			
		</ul>
		<!-- 对话框的确定和取消按钮 -->
		<div id="buttons">
			<a href="#" class="easyui-linkbutton" id="btn_select" iconCls="icon-ok">确定</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dialog').dialog('close')">取消</a>
		</div>
	</div>
</body>
</html>