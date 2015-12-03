<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 引入公共头部，里面有easyui基本文件 -->
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script><!-- 是否需要公共js(js变量空判断) -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/systemdictionary/systemdictionarytype.js"></script>
<title>数据字典管理</title>
</head>
<body class="easyui-layout" fit="true" border="false">
	<div data-options="region:'west',split:false" style="width:45%;">
		<div class="easyui-layout" style="width:100%;height:100%;">   
		    <!-- <div data-options="region:'north',split:false" style="height:60px;width:100%;">
		    </div> -->
		    
		    <div data-options="region:'center',title:'数据字典类型管理'" style="padding:5px;">
		    	<table id="datagrid" style="width:700px;height:300px"></table>
		    </div>
		    
		    <div data-options="region:'north',split:false" style="width:100%;">
		    	<div class="datagrid-toolbar">
					<table cellpadding="0" cellspacing="0" style="width: 100%">
						<tr>
							<td>
								<a href="#" class="easyui-linkbutton" id="add1" iconCls="icon-add" plain="true">增加</a>
								<a href="#" class="easyui-linkbutton" id="edit1" iconCls="icon-edit" plain="true">编辑</a>
							<!-- 	<a href="#" class="easyui-linkbutton" id="remove1" iconCls="icon-remove">删除</a> -->
							</td>
						</tr>
					</table>
				</div>
		    </div>
		</div>
		
	</div>
	
	<div data-options="region:'east',split:false" style="width:55%;">
    	<div class="easyui-layout" style="width:100%;height:100%;">   
		    <!-- <div data-options="region:'north',split:false" style="height:60px;width:100%;">
		    </div> -->
		    
		    <div data-options="region:'center',title:'数据字典管理',split:false" style="padding:5px;">
				<table id="datagrid2" style="width:700px;height:300px">
       			</table>
		    </div>
		    
		    <div data-options="region:'north',split:false" style="width:100%;">
		    	<div class="datagrid-toolbar">
					<table cellpadding="0" cellspacing="0" style="width: 100%">
						<tr>
							<td>
								<a href="#" class="easyui-linkbutton" id="add2" iconCls="icon-add" plain="true">增加</a>
								<a href="#" class="easyui-linkbutton" id="edit2" iconCls="icon-edit" plain="true">编辑</a>
								<a href="#" class="easyui-linkbutton" id="remove2" iconCls="icon-remove" plain="true">删除</a>
							</td>
						</tr>
					</table>
				</div>
		    </div>
		    
		</div>  
    </div>
    
    <div id="dialog" class="easyui-dialog"
		style="width:500px; height:250px;" closed="true"
		modal="true" maximizable="true" buttons="#dlg-buttons">
		<form id="form" method="post" class="ui-form">
			<!-- 表单可用class ui-form-item/fn-right -->
			<div class="ui-form-item">
				<label for="dict_name" class="ui-form-item-label">数据字典名称</label>
				<input name="dict_name" id="dict_name" class="easyui-textbox" required="true" missingMessage="必填" />
			</div>
			
			<div class="ui-form-item">
				<label for="desciption" class="ui-form-item-label">描述</label>
				<textarea rows="5" cols="50" name="desciption" id="desciption"></textarea>
			</div>
			
			<div id="ids"></div>
			<!-- 表单不需要显示的字段-->
			<div style="display:none">
				<!-- 主键值-->
				<input name="increment_id" id="increment_id" />
				<input name="del_flag" id="del_flag" value="0"/>
				
				<div class="ui-form-item">
					<label for="create_by" class="ui-form-item-label">创建者</label>
					<input name="create_by" id="create_by" class="easyui-textbox" />
				</div>
					
				<div class="ui-form-item">
					<label for="create_time" class="ui-form-item-label">创建时间</label>
					<input name="create_time" id="create_time" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item">
					<label for="update_by" class="ui-form-item-label">修改者</label>
					<input name="update_by" id="update_by" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item">
					<label for="update_time" class="ui-form-item-label">修改时间</label>
					<input name="update_time" id="update_time" class="easyui-textbox" />
				</div>
				
			</div>
		</form>
		
		<!-- 对话框的确定和取消按钮 -->
		<div id="dlg-buttons">
			<a href="#" class="easyui-linkbutton" id="submit" iconCls="icon-ok">确定</a> 
			<a href="#" class="easyui-linkbutton" id="cancel" iconCls="icon-cancel" onclick="javascript:$('#dialog').dialog('close')">取消</a>
		</div>
	</div>
	
	<div id="dialog2" class="easyui-dialog"
		style="width:500px; height: 300px;" closed="true"
		modal="true" maximizable="true" buttons="#dlg-buttons2">
		<form id="form2" method="post" class="ui-form">
			<!-- 表单可用class ui-form-item/fn-right -->
			<div class="ui-form-item">
				<label for="name" class="ui-form-item-label">名称</label>
				<input name="name" id="name" class="easyui-textbox" required="true" missingMessage="必填" />
			</div>
			
			<div class="ui-form-item">
				<label for="sort" class="ui-form-item-label">指定顺序(整数)</label>
				<input name="sort" id="sort" class="easyui-textbox" />
			</div>
			
			<div class="ui-form-item">
				<label for="description" class="ui-form-item-label">描述</label>
				<textarea name="description" id="description" rows="5" cols="50"></textarea>
			</div>
			
			<div id="ids2"></div>
			<!-- 表单不需要显示的字段-->
			<div style="display:none">
				<!-- 主键值-->
				<input name="increment_id" id="increment_id2" />
				<input name="del_flag" id="del_flag2" value="0" />
				<div class="ui-form-item">
					<label for="create_by" class="ui-form-item-label">创建者</label>
					<input name="create_by" id="create_by" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item">
					<label for="create_time" class="ui-form-item-label">创建时间</label>
					<input name="create_time" id="create_time" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item">
					<label for="update_by" class="ui-form-item-label">修改者</label>
					<input name="update_by" id="update_by" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item">
					<label for="update_time" class="ui-form-item-label">修改时间</label>
					<input name="update_time" id="update_time" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item">
					<label for="father_id" class="ui-form-item-label">配置项归属ID</label>
					<input name="father_id" id="father_id" class="easyui-textbox" />
				</div>
			</div>
		</form>
		
		<!-- 对话框的确定和取消按钮 -->
		<div id="dlg-buttons2">
			<a href="#" class="easyui-linkbutton" id="submit2" iconCls="icon-ok">确定</a> 
			<a href="#" class="easyui-linkbutton" id="cancel2" iconCls="icon-cancel" onclick="javascript:$('#dialog2').dialog('close')">取消</a>
		</div>
	</div>
	
</body>
</html>
