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
</script>
</head>
<body>
<form action="../register" method="post" onSubmit="return check_admin(this)">
	<table  border="2px" align="center" width="660px" height="300px">
	<tr>
		<th bgcolor=red colspan="6" align="center" font-size="red">用户注册</th>
	</tr>
	<tr>
		<td  colspan="2" rowspan="6"><img src="./images/极光.jpg" width="390px" height="300px"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">用户名：</td>
		<td colspan="2">&nbsp;<input type="text" name="username">*</td>
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
	<tr>
		<td colspan="4" align="center">
		<input type="submit" value="提交">
		&nbsp;<input type="reset" value="重填" >
		&nbsp;<a href="login.htm">点此登录！</a>
		</td>
	</tr>
	</table>
</form>
</body>
</html>