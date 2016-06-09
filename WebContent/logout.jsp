<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${todo}" />
<fmt:setBundle basename="com.example.language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer" lang="${todo}">

</head>
<body>
<form id = "LogOut " action="logoutServlet" method="post">


<fmt:message key="logout.button.submit" var="buttonValue3" />
<tr>
									<td colspan="2"><input type="submit" class="btn btn-primary" name="logo" value="${buttonValue3}"></td>
								</tr>

</form>
</body>
</html>


