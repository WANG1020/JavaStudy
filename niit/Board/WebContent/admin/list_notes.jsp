<%@page import="note.util.SplitPage"%>
<%@page import="note.vo.person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter" import="note.factory.DAOFactory"
    import="java.util.List" import="java.util.ArrayList" import="note.vo.Note" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>
<style>
span{color:#eeaa33;font-size:37px}
table{width:360px;height:200px}
a{margin:0 5px}
</style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");

SplitPage splitpage=new SplitPage();
splitpage.confirmPage("first");
String s_pageNow=request.getParameter("pageNow");
if(s_pageNow!=null){
	splitpage.setCurrentPage(Integer.parseInt(s_pageNow));
}
%>
<center>
<%String username=(String)session.getAttribute("username");
	person person=new person();
	person.setUserName(username);
	String src=DAOFactory.getPersonDAOInstance().checkPersonImg(person);%>
<p><img src="<%=src%>" width="60px" height="60px"><a href='login_sucess.jsp'>首页</a> <span>JSP学习论坛留言板</span> <a href=login.htm>退出登录</a></p><hr>
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
<jsp:useBean id="spage" class="note.util.SplitPage" scope="session"></jsp:useBean>

<%if(session.getAttribute("username")!=null){%>
	<table border=1px cellspacing=0>
	<tr>
	<th>id</th>
	<th>title</th>
	<th>author</th>
	<th>content</th>
	<th>删除</th>
	</tr>
<% 
	List<Note> lists=splitpage.pageContent();

	for(int i=0;i<lists.size();i++){%>
		<tr>
		<td>
		<%out.println(lists.get(i).getId());%>
		</td>
		<td>
		<%out.println(lists.get(i).getTitle());%>
		</td>
		<td>
		<%out.println(lists.get(i).getAuthor());%>
		</td>
		<td>
		<%out.println(lists.get(i).getContent());%>
		</td>
		<td>
		<a href=deleteNote.jsp?id=<%=lists.get(i).getId()%>>删除</a>
		</td>
		</tr>
	<% }
%>
	<tr>
	<td colspan=5>
	<center>
<%	for(int i=1;i<splitpage.getTotalPages()+1;i++){
		if(i<splitpage.getTotalRows()+1){
			out.println("<a href=list_notes.jsp?pageNow="+splitpage.confirmPage(String.valueOf(i))+ ">" + i +"</a>");
		}
	}
	if(splitpage.getCurrentPage()!=1){
		out.print("<a href=list_notes.jsp?pageNow="+splitpage.confirmPage("first")+">"+"首页"+"</a>");
		out.print("<a href=list_notes.jsp?pageNow="+splitpage.confirmPage("previous")+">"+"上一页"+"</a>");
	}
	if(splitpage.getCurrentPage()!=splitpage.getTotalPages()){
		out.print("<a href=list_notes.jsp?pageNow="+splitpage.confirmPage("next")+">"+"下一页"+"</a>");
		out.print("<a href=list_notes.jsp?pageNow="+splitpage.confirmPage("last")+">"+"尾页"+"</a>");
	}
%>
	<select id="selectpage" name="gopage" onchange="javascript:go();"><!-- 功能不完整 -->
	<%for(int i=1 ;i<=splitpage.getTotalPages();i++) {
		out.print("<option name=pagechoose><a href=list_notes.jsp?pageNow="+i+">"+i+"/"+splitpage.getTotalPages()+"</a></option>");
	}
}
%>
</select>
</center>
</td>
</tr>
</table>
</form>
</center>
</body>
</html>