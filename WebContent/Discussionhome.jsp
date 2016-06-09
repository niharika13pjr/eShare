<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#90EE90" BACKGROUND="${pageContext.request.contextPath}/images/lock-1.jpg"/>
<h1 align="center"><i><mark>WELCOME TO THE USER DISCUSSION FORUM PAGE</mark></i></h1><br>
<a style="color:black;" href='logout.jsp'><input type="submit" value="Logout" /></a><br><br>
<img align="right-top" src="images/c11.jpg" style="width:340px;height:200px;">
<img align="left" src="images/p1.jpg" style="width:250px;height:200px;">
<img align="left" src="images/gp4.jpg" style="width:250px;height:200px;">
<img align="left" src="images/b2.png" style="width:250px;height:200px;">
<img align="right" src="images/gp5.jpg" style="width:250px;height:200px;">
<form action="Dissservlet" method="post"><br>
<a href="topiccreate.jsp"><mark>CREATE DISCUSSION TOPICS</mark></a><br><br>
<input type="submit" value = "Existing discussion topics"><br><br>
</form>
</body>
</html>