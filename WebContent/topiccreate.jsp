<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body style="background-color:#90EE90" BACKGROUND="${pageContext.request.contextPath}/images/lock-1.jpg"/>
<img align="middle" src="images/main.jpg" style="width:1090px;height:100px;"><br><br>
<h1 align="middle"><i><mark>KINDLY CREATE NEW TOPICS HERE</mark></i></h1><br>

<%String bigerror=(String)request.getAttribute("bigerror");
if(null != bigerror)
	out.print(bigerror);

%>
<%
String dell=(String)request.getAttribute("dell");
if(null != dell)
System.out.print(dell);
%>
<form name="Form" action="Discussionservlet" method="post" onsubmit="return validateForm()"> 
 
<strong><h1><mark>Create a discussion topic:</mark></h1></strong>


<input type="text" placeholder="enter a name here" name="name"/><br/> <br> 
<input type="submit" value="submit"/><br><br>
<a href='Discussionhome.jsp'>Go Back</a>



</form>

</body>
</html>