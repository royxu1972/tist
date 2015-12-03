<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- contextPath变量是在ajax请求的$url变量中用到 -->
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入公共头部，里面有easyui基本文件 -->
<jsp:include page="/jsp/include/euInc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dateformat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/user/user.js"></script>
<title>用户列表</title>
</head>
<body class="easyui-layout" fit="true" border="false">
	<!-- easyui的北部布局，主要放工具栏 -->
	<div region="north" border="false">
		<div class="datagrid-toolbar">
			<table cellpadding="0" cellspacing="0" style="width: 100%">
				<tr>
					<td>
					 	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>  
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- easyui的中部布局，放一个easyui的datagrid列表，用户展示数据 -->
	<div region="center" border="false" style="overflow: hidden;">
		<table id="datagrid"  style="width:700px;height:300px" data-options="
			    rownumbers:true,
                singleSelect:true,
                autoRowHeight:false,
                pagination:true,
                pageSize:10">
        </table>
	</div>
	
	<!-- 
		easyui的对话框，它不属于布局内部的一部分，只有在增加和编辑的时候调用这个对话框。
		增加的时候显示一个空表单的对话框。
		编辑的时候将选中的某行数据载入表单中。		
	 -->
	<div id="dialog" class="easyui-dialog"
		style="width:600px; height: 450px;" closed="true"
		modal="true" maximizable="true" maximized="true" buttons="#dlg-buttons">
		<form id="form" method="post" novalidate class="ui-form">
			<!-- 
				隐藏了自增主键id，从用户体验的角度来看不需要显示，
				但是要注意：
					1、由于是自增id，所以增加的时候不能将id传到后台，因此需要通过jQuery的attr方法给文本框添加disabled为true的属性。
					2、由于sql的更新操作需要一个修改条件如update user set user_name="peter" where id="2"	
					        修改的时候需要一个条件，Hibernate的update方法需要提供一个主键值，因此需要把这个id的disabled属性值改为false。
					        如果想通过其他方式修改，则需要自己在后台添加对应的hql语句执行对应方法。
				解释：html标签中有个disabled的属性，该属性默认值为false，如果将其设置为true或者disabled，则该元素不会提交到后台。
			-->
			<input name="user_id" id="increment_id" type="hidden" />
			<input name="del_flag" id="del_flag" type="hidden" />
			<!-- 
				表单的核心部分，每一个div是一个小整体，包括一个label标签和一个文本框。每两个div是左右摆放的样式。
				注意：表单中的input的name值必须和对应的实体类中的成员变量完全一致。
				如本例中，表单提交是封装在com.springmvc.domain.User这个类中的。
				User类中有三个成员：id，user_name，user_password，因此包括上面隐藏的input，每个input中的
				name值也分别为id，user_name，user_password，如果name值与成员变量的值不一致，将会发生无法封装到User类中的情况。
			 -->
			 <fieldset id="bansic_info">
				<legend>基本信息</legend>
				<div class="ui-form-item2 fn-left">
					<label for="login_name" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>登录用户名</label>
					<input name="login_name" id = "login_name" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="user_password" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>登陆密码</label>
					<input name="user_password" id ="user_password" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item2 fn-left">
					<label for="user_name" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>员工姓名</label>
					<input name="user_name" id = "user_name" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="sex" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>性别</label>
					<select name="sex" id ="sex" class="easyui-combobox" style="width:100px;">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
				
				<div class="ui-form-item2 fn-left">
					<label for="user_no" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>员工编号</label>
					<input name="user_no" id = "user_no" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="department_id" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>所属部门</label>
					<input name="department_id" id ="department_id" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item2 fn-left">
					<label for="mobilephone" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>手机号码</label>
					<input name="mobilephone" id = "mobilephone" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="phone" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>家庭电话</label>
					<input name="phone" id ="phone" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item2 fn-left">
					<label for="enter_time" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>入职时间</label>
					<input name="enter_time" id = "enter_time" class="easyui-datebox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="leave_time" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>离职时间</label>
					<input name="leave_time" id ="leave_time" class="easyui-datebox" />
				</div>
				
				<div class="ui-form-item">
					<label for="bank_card" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>银行卡号</label>
					<input name="bank_card" id = "bank_card" class="easyui-textbox">
				</div>
				
				<div class="ui-form-item">
					<label for="note" class="ui-form-item-label"><em class="ui-form-required fn-hide">*</em>备注</label>
					<textarea rows="4" style="width:50%;" name="note" id="note"></textarea>
				</div>
			</fieldset>
			
			<fieldset id="other_info">
				<legend>其他信息</legend>
				<div class="ui-form-item2 fn-left">
					<label for="create_by" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>创建者</label>
					<input name="create_by" id = "create_by" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="create_time" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>创建时间</label>
					<input name="create_time" id ="create_time" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item2 fn-left">
					<label for="login_ip" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>登陆ip</label>
					<input name="login_ip" id = "login_ip" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="login_time" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>登陆时间</label>
					<input name="login_time" id ="login_time" class="easyui-textbox" />
				</div>
				
				<div class="ui-form-item2 fn-left">
					<label for="update_by" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>修改者</label>
					<input name="update_by" id = "update_by" class="easyui-textbox" >
				</div>
				<div class="ui-form-item2 fn-right">
					<label for="update_time" class="ui-form-item2-label"><em class="ui-form-required fn-hide">*</em>修改时间</label>
					<input name="update_time" id ="update_time" class="easyui-textbox" />
				</div>
			</fieldset>
			<!-- 
				ids的div只有在删除的时候调用，Hibernate提供的deleteAll()删除选中的记录是根据主键删除的。 
				当勾选完需要删除的记录的时候，通过jQuery的方法将选中的记录的id插入到这个div中。
				即：
				<div id="ids">
					<input name="ids" type="hidden" value="1" />
					<input name="ids" type="hidden" value="2" />
					<input name="ids" type="hidden" value="3" />
				</div>
				则删除的时候会将主键值为1,2,3的记录全部删除
			-->
			<div id="ids"></div>
			<!-- 表单提交的时候对应的操作方法。-->
            <input type="hidden" name="_method" value="post"/>
		</form>
		
		<!-- 对话框的确定和取消按钮 -->
		<div id="dlg-buttons">
			<a href="#" class="easyui-linkbutton" id="submit" iconCls="icon-ok">确定</a> 
			<a href="#" class="easyui-linkbutton" id="cancel" iconCls="icon-cancel" onclick="javascript:$('#dialog').dialog('close')">取消</a>
		</div>
	</div>
	
</body>
</html>