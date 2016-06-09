<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#90EE90" BACKGROUND="${pageContext.request.contextPath}/images/lock-1.jpg"/>
<h1 align="center"><i><mark>KINDLY VIEW TOPICS LIST HERE</mark></i></h1><br>
<img align="right" src="images/gp6.jpg" style="width:450px;height:280px;">
<%ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
ArrayList<String> namelist = (ArrayList<String>) request.getAttribute("namelist");%>
<%for (int i = 0;i<list.size();i++) {%>
<li>Topic Name:</li><a href="ViewServlet?topic=<%=list.get(i)%>"><%=list.get(i)%></a> By: <%=namelist.get(i) %><br><br>
<%} %>
<br><a href='Discussionhome.jsp'>Go Back</a>
</body>
</html>