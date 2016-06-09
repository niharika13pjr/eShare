<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer" lang="${language}">
<body bgcolor="white">
<a href="http://www.dominoz.com"><img src="<%= request.getContextPath()%>/images/ad1.jpg" style="height: 110px; width: 110px;" class="img"></a>
<font size="3">
<h2 style="color:black;">50 % discount</h2>
</font>
<h2 style="color:red;" size ="2">on all ONLINE ORDERS at PIZZA HUT</h2>
<a href="http://www.subway.com"><img src="<%= request.getContextPath()%>/images/su2.jpg" style="height: 100px; width: 100px;" class="img"></a>
<font size="3">
<h2 style="color:black;">BOGO on Subs!!</h2>
</font>
<h2 style="color:red;" size ="2">Buy one and get one sub at SUBWAY!</h2>

</body>
</html>