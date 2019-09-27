<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
<link rel="stylesheet" src="css/common.css">
<style>
body{
    background-image:url("images/极光.jpg");
}
#wrapper{
	text-align:center;
	font-size:30px;
	position: absolute;
    top: 40%;
    left: 40%;
}
#wrapper p{
font-size:25px;
}
</style>
</head>
<body>
<center></br></br></br>
<font class="title">Jsp学习论坛</font>
<hr>
<br/>
<%
HttpSession hSession=request.getSession(true);
String name1=(String)hSession.getAttribute("username");
String password1=(String)hSession.getAttribute("upass");
Boolean flag=(Boolean)hSession.getAttribute("flag");
int number=(int)hSession.getAttribute("fkNumber");
if(name1!=null){
	%><font color="green">
		<h2>登录成功！
		欢迎<font size="12" color="red">
			<%= name1 %></font>
			<%if(flag){/* flag为1是管理员，0不是 */
				%>
				管理员
			<% }%>
		光临留言板
		</h2>
		<h3><a href="???">用户管理</a> 
		&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
		<a href="list_notes1.jsp">进入留言板</a>
		</h3>
		<h4>你是第<%=number %>位访客</h4>
		<a href="???"><img src="images/留言.jpg" width="80px" height="60px"></a>
	</font>
	<%
	
	%>
<% }else{
	response.setHeader("refresh", "2;URL=login.htm");
}
%>

</center>
<%-- <div id="wrapper">
<% 
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");

HttpSession hSession=request.getSession(true);
String name1=(String)hSession.getAttribute("username");
String password1=(String)hSession.getAttribute("upass");
Boolean flag=(Boolean)hSession.getAttribute("flag");
if(flag){
	out.println("欢迎你"+"&nbsp"+name1+"&nbsp管理员&nbsp进入系统！");
}else{
	out.println("欢迎你"+"&nbsp"+name1+"&nbsp进入系统！");
}
%>
<p><a href="#">人员管理</a><a href="#">进入系统</a></p>
</div> --%>
</body>
</html>