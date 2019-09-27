<%@page import="note.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="6;url=list_notes1.jsp"><!-- 在此页面停留6秒，返回list_notes页面 -->
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");

String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
DAOFactory.getNoteDAOInstance().delete(id);
if(DAOFactory.getNoteDAOInstance().search(id)){
	out.println("删除失败！！将在6秒后，跳转list_notes1.jsp页面");
}else{
	out.println("删除成功！！将在6秒后，跳转list_notes1.jsp页面");
}
%>
</body>
</html>