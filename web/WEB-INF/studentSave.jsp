<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var name=$("#name").val();
		var sex=$("#sex").val();
		var classNo=$("#classNo").val();
		var major=$("#major").val();
		var password=$("#password").val();
		if(name==null||name===""){
			$("#error").html("姓名不能为空！");
			return false;
		}
		if(sex==null||sex===""){
			$("#error").html("请选择性别！");
			return false;
		}
		if(classNo==null||classNo===""){
			$("#error").html("班号不能为空！");
			return false;
		}
		if(major==null||major===""){
			$("#error").html("专业不能为空！");
			return false;
		}
		if(password==null||password===""){
			$("#error").html("密码不能为空！");
			return false;
		}
		return true;
	}
</script>
<div class="data_list">
	<div class="data_info">
		<p></p>
	</div>
	<div class="data_content" >
		<form action="classInfo?action=addStudent" method="post" onsubmit="return checkForm()">
		<table width="80%" align="center">
			<tr>
				<td><label>姓名：</label></td>
				<td><input type="text" id="name" name="name" value=""/></td>
				<td>&nbsp;</td>
				<td><label>性别：</label></td>
				<td>
					<select id="sex" name="sex">
						<option value="">请选择性别...</option>
						<option value="男" >男</option>
						<option value="女" >女</option>
					 </select>
				</td>
			</tr>
			<tr>
				<td><label>班号：</label></td>
				<td colspan="4">
						<input type="text" id="classNo" name="classNo" value="" class="input-xlarge"/>
				</td>
			</tr>
			<tr>
				<td><label>专业：</label></td>
				<td>
					<input type="text" id="major" name="major" value=""/>
				</td>
				<td>&nbsp;</td>
				<td><label>密码：</label></td>
				<td>
					<input type="text" id="password" name="password" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="id" name="student.id" value=""/><input type="submit" class="btn btn-primary" value="保存"/>
				</td>
				<td colspan="4">
		   		   <button class="btn btn-primary" type="button" onclick="window.location='classInfoManage'">
                       返回
                   </button>
                    &nbsp;<font id="error" color="red">${state}</font>
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
