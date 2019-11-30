<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style/studentInfo.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm(){
		var id=document.getElementById("id").value;
		var password=document.getElementById("password").value;
		if(id==null||id==""){
			alert("学号不能为空！");
			return false;
		}
		if(password==null||password==""){
			alert("密码不能为空！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		document.getElementById("id").value="";
		document.getElementById("password").value="";
	}
</script>
</head>
<body >
<div align="center" style="padding-top: 20px;" >
		<form action="login" method="post" onsubmit="return checkForm()">
            <input name="identity" value="student" type="hidden">
		<table  width="1004" height="584" background="image/login.jpg" >
			<tr height="200">
				<td colspan="4"></td>
			</tr>
			<tr height="10">
				<td width="68%"></td>
				<td width="10%"><label>学号：</label></td>
				<td><input type="text" id="id" name="userId" value="${identity}"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="40%"></td>
				<td width="10%"><label>密码：</label></td>
				<td><input type="password" id="password" name="password"/></td>
				<td width="30%"></td>
			</tr>

			<tr height="10">
				<td width="40%"></td>
				<td width="10%"><button class="btn btn-primary" type="submit">登录</button></td>
				<td><button class="btn btn-primary" type="button"  onclick="resetValue()">重置</button></td>
				<td width="30%"></td>
			</tr>
			<tr >
				<td></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	if('${error}'!=''){
		alert('${error}');
	}
</script>