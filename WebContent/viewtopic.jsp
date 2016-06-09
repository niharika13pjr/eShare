<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#90EE90" BACKGROUND="${pageContext.request.contextPath}/images/lock-1.jpg"/>
<h1 align="center"><i><mark>VIEW TOPICS HERE</mark></i></h1><br>
<form action="Topicviewservlet" method="post">
 <%ArrayList<String> contents = (ArrayList<String>) request.getAttribute("contents"); %>
 <%if (contents.size() == 0) {%>
Not Post yet in this topic <br>
 <%} %>
<%if(contents.size() > 0) {%>
<% for (int i =0;i<contents.size();i++) {%>
<%=contents.get(i) %><br>
<%} %>
<%} %>
<%String topic= (String) request.getAttribute("topic"); %>
<input type="text" name="replyContent"><br>
<input type="hidden" name="topic" value="<%=topic%>">
<input type="submit" value="Reply"/><br><br>
</form>
</body>
</html>