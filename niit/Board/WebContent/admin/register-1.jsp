<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function check_admin(form)
{
	if(form.username.value=="")
	{
		alert("请输入用户账号!");
		form.name.focus();
		return false;
	}
	if(form.password1.value=="")
	{
		alert("请输入用户密码!");
		form.password.focus();
		return false;
	}
	if (form.password2.value=="")
	{
		alert("请确认密码!");
		form.password2.focus();
		return false;
	}
	if(form.password1.value!=form.password2.value){
		alert("密码不同，请重新输入!");
		form.password2.focus();
		return false;
	}
	return true;
}
function showImg() {
	var simgsrc=document.all.head.value;
	console.log(simgsrc);
	document.getElementById('Image').src=simgsrc;
	var imgsrc=document.getElementById('imgsrc');
	imgsrc.value=simgsrc; 
}
</script>
</head>
<body>
<form action="../register" method="post" onSubmit="return check_admin(this)">
	<table  border="2px" align="center" width="700px" height="300px" cellspacing="0" cellpadding="0">
	<tr>
		<th bgcolor=red colspan="6" align="center" font-size="red">用户注册</th>
	</tr>
	<tr>
		<td  colspan="2" rowspan="8" width="320px" height="350px"><img src="./images/极光.jpg" width="340px" height="350px"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">用户名：</td>
		<td colspan="2">&nbsp;<input type="text" name="username">*</td>
	</tr>
	<tr>
		<td colspan="2">用户头像：</td>
		<td><select id="head" onchange="showImg();">
			<option value="img/头像1.png" selected>Image 1</option>
			<option value="img/头像2.png">Image 2</option>
			<option value="img/头像3.png">Image 3</option>
			<option value="img/头像4.png">Image 4</option>
			<option value="img/头像5.png">Image 5</option>
			<option value="img/头像6.png">Image 6</option>
			<option value="img/头像7.png">Image 7</option>
			<option value="img/头像8.png">Image 8</option>
			<option value="img/头像9.png">Image 9</option>
			<option value="img/头像10.png">Image 10</option>
		</select></td>
		<td width="50px" height="50px">
			<img id="Image"  src="img/头像1.png" width="50px" height="50px">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">密码：</td>
		<td  colspan="2">&nbsp;<input type="password" name="password1">*</td>
	</tr>
	<tr>
		<td colspan="2" align="center">确认密码：</td>
		<td  colspan="2">&nbsp;<input type="password" name="password2">*</td>
	</tr>
	<tr>
		<td colspan="2" align="center">电子邮箱：</td>
		<td  colspan="2">&nbsp;<input type="text" name="email">*</td>
	</tr>
	<tr><input type="hidden" id="imgsrc" name="imgsrc" value="img/头像9.png"></tr>
	<tr>
		<td colspan="4" align="center">
		<input type="submit" value="提交">
		&nbsp;<input type="reset" value="重填" >
		&nbsp;<a href="login-1.html">点此登录！</a>
		</td>
	</tr>
	</table>
</form>
</body>
</html>