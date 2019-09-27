<%@page import="note.vo.person"%>
<%@page import="note.factory.DAOFactory"%>
<%@page import="note.util.SplitPage"%>
<%@page import="note.dao.impl.noteDaoImpl"%>
<%@page import="note.dao.noteDao"%>
<%@page import="note.vo.Note"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
span{color:#eeaa33;font-size:37px}
table{width:360px;height:200px}
a{margin:0 5px}
</style>
<jsp:useBean id="spage" class="note.util.SplitPage" scope="session"></jsp:useBean>
<script>
	function  go() {
		var gopage=document.all.selectpage.value;
		alert("将前往页面list_notes1.jsp?flag="+gopage);
		window.open("list_notes1.jsp?flag="+gopage);
	}
</script>
</head>
<body>
<center>
<% 
if(session.getAttribute("username")!=null){%>
	<img src="images/images1.jpg" width="100%" height="80px">
	<%String username=(String)session.getAttribute("username");
	person person=new person();
	person.setUserName(username);
	String src=DAOFactory.getPersonDAOInstance().checkPersonImg(person);%>
	<p><img src="<%=src%>" width="60px" height="60px"><a href='login_sucess.jsp'>首页</a> <span>JSP学习论坛留言板</span> 
	<%if((Boolean)session.getAttribute("flag")){%>
		<a href=login.htm>退出登录</a>
	<%}else{%>
		<a href=login-1.html>退出登录</a>
	<%} %></p><hr>
	<h2><a id=showall href='##'>显示所有留言</a></h2>
	<p>在<select>
	<option value=title selected>标题</option>
	<option value=author selected>作者</option>
	<option value=id selected>id</option>
	</select>中查询：
	<input type=text name=query />
	<input type=button name=querybtn value=搜索></p>
	<a href='insert.jsp'><h2>添加新留言</h2></a>
	<form name="form1" method="post">
	<% String flag=request.getParameter("flag");
	int totalRows=0;
	int currentPage=1;
	spage.confirmPage(flag);
%>
<table border=1px cellspacing=0>
<tr>
	<th>id</th>
	<th>title</th>
	<th>author</th>
	<th>content</th>
	<th>删除</th>
</tr>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
List<Note> list=null;
noteDao nodao=new noteDaoImpl();
totalRows=nodao.queryAll().size();
spage.setTotalRows(totalRows);
list=nodao.findAll(spage);
for(Note n:list){
	%>
	<tr>
		<td><%=n.getId()%></td>
		<td><%=n.getTitle()%></td>
		<td><%=n.getAuthor()%></td>
		<td><%=n.getContent()%></td>
		<td><a href=deleteNote.jsp?id=<%=n.getId()%>>删除</a></td>
	</tr>
	<% 
}
%>
<tr>
<td colspan=5>
<center>
	<%if(spage.getCurrentPage()>=1){ %>
	<a href="list_notes1.jsp?flag=<%=SplitPage.FIRSTPAGE %>">首页</a>
		<%if(spage.getCurrentPage()==1){ %><!-- 如果在第一页，那么上一页还是这一页 -->
			<a href="list_notes1.jsp?flag=<%=SplitPage.FIRSTPAGE %>">上一页</a>
		<%}else{ %>
			<a href="list_notes1.jsp?flag=<%=SplitPage.PREVIOUSEPAGE %>">上一页</a>
		<%}
	} %>
	<%if(spage.getCurrentPage()<=spage.getTotalPages()){ %>
		<%if(spage.getCurrentPage()==spage.getTotalPages()){ %>
			<a href="list_notes1.jsp?flag=<%=SplitPage.LASTPAGE %>">下一页</a>
		<%}else{ %>
			<a href="list_notes1.jsp?flag=<%=SplitPage.NEXTPAGE %>">下一页</a>
		<%} %>
	<a href="list_notes1.jsp?flag=<%=SplitPage.LASTPAGE %>">尾页</a>
	<%} %>
	<select id="selectpage" name="gopage" onchange="javascript:go();">
		<%for(int i=1;i<=spage.getTotalPages();i++){ %>
			<option value="<%=i %>" <%=(spage.getCurrentPage()==i)? 
					"selected='selected'":"" %>> <%=i %>/<%=spage.getTotalPages() %></option>
		
		<%}%>
</select>
</center>
</td>
</tr>
</table>
<%	
}
%>
</form>
</body>
</html>