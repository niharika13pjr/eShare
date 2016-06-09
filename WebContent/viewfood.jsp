<%@ page import = "eshare.model.Registration" import ="java.util.ArrayList" import = "eshare.model.food" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${todo}" />
<fmt:setBundle basename="com.example.language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer" lang="${todo}">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Food Sharing</title>
<link href="css/vendor.min.css" rel="stylesheet">
<link href="css/theme-core.min.css" rel="stylesheet">
<link href="css/module-essentials.min.css" rel="stylesheet" />
<link href="css/module-layout.min.css" rel="stylesheet" />
<link href="css/module-sidebar.min.css" rel="stylesheet" />
<link href="css/module-sidebar-skins.min.css" rel="stylesheet" />
<link href="css/module-navbar.min.css" rel="stylesheet" />
<link href="css/module-timeline.min.css" rel="stylesheet" />
<link href="css/module-cover.min.css" rel="stylesheet" />
<link href="css/module-chat.min.css" rel="stylesheet" />
<link href="css/module-maps.min.css" rel="stylesheet" />
</head>

<body class="login">

<%
ArrayList<food> ls = (ArrayList<food>)request.getAttribute("foodList");
%>
	<div id="content">
		<div class="container-fluid">
			<div class="lock-container" style="width: 450px;">
				<h1><label for="allfood"><fmt:message key="viewfood.label.allfood" /></label></h1>
				
				<!-- implement order by item user selected... -->
				<form action="FoodModuleViewbyOrderServlet" method="post">
				<label for="orderby"><fmt:message key="viewfood.label.orderby" /></label><select name="options" onchange="this.form.submit()">
						<option value="foodprice"><h1><label for="price"><fmt:message key="viewfood.label.price" /></label></h1></option>
						<option value="foodtype"><h1><label for="type"><fmt:message key="viewfood.label.type" /></label></h1></option>
						<option value="timeposted"><h1><label for="time"><fmt:message key="viewfood.label.time" /></label></h1></option>
					</select>
				</form>
				<div class="panel panel-default text-center"
					style="max-width: 450px ! important;">
					<!-- <img src="images/guy-5.jpg" class="img"> -->
					<!-- dropbox -->
					
					<div class="panel-body">
					 <%for(int i = 0; i < ls.size();i++){ %>
					
						<form action="FoodModuleFinalTransactionServlet" method="post">
							<table>
								<br>
								<label for="foodtype"><fmt:message key="viewfood.label.foodtype" /></label>
									<%=ls.get(i).getFoodType() %>
								
									<label for="foodprice"><fmt:message key="viewfood.label.foodprice" /></label>
									<%=ls.get(i).getFoodPrice() %> <br>
								
								
									<label for="peopleneeded"><fmt:message key="viewfood.label.peopleneeded" /></label>
									<%=ls.get(i).getPeopleNeeded() %>
								
									<label for="foodquantity"><fmt:message key="viewfood.label.foodquantity" /></label>
								<%=ls.get(i).getFoodQuantity() %><br>
								
									<label for="venue"><fmt:message key="viewfood.label.venue" /></label>
									<%=ls.get(i).getVenue() %>
								
									<label for="paymenttype"><fmt:message key="viewfood.label.paymenttype" /></label>
									<%=ls.get(i).getPaymentType() %><br>
									<label for="comments"><fmt:message key="viewfood.label.comment" /></label>
									<%=ls.get(i).getComments() %><br>
								
								<!-- since food type is foreign key we can use foreign to track all of the rest of data -->
									<td colspan="2">
									<input name='foodID' value ="<%=ls.get(i).getFoodID() %>" type='hidden'>								
									
									<fmt:message key="viewfood.label.submit" var="buttonValueviewfood" />                                                               
							
									<td colspan="2"><input type="submit"
										class="btn btn-primary" name="submit" value="${buttonValueviewfood}">
																
										<a href="home.jsp"><h1><label for="returnhome"><fmt:message key="viewfood.label.returnhome" /></label></h1></a>
															
							</table>
												</form>
							<%} %>
					</div>
					<a href="postfood.jsp">Click to share your food...</a><br>
					<a href="Discussionhome.jsp">Click here go to Discussion forum</a><br>
					<a href="bank.jsp">Click here to go to Our Bank Page</a>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		var colors = {
			"danger-color" : "#e74c3c",
			"success-color" : "#81b53e",
			"warning-color" : "#f0ad4e",
			"inverse-color" : "#2c3e50",
			"info-color" : "#2d7cb5",
			"default-color" : "#6e7882",
			"default-light-color" : "#cfd9db",
			"purple-color" : "#9D8AC7",
			"mustard-color" : "#d4d171",
			"lightred-color" : "#e15258",
			"body-bg" : "#f6f6f6"
		};
		var config = {
			theme : "social-1",
			skins : {
				"default" : {
					"primary-color" : "#16ae9f"
				},
				"orange" : {
					"primary-color" : "#e74c3c"
				},
				"blue" : {
					"primary-color" : "#4687ce"
				},
				"purple" : {
					"primary-color" : "#af86b9"
				},
				"brown" : {
					"primary-color" : "#c3a961"
				}
			}
		};
	</script>
	<script src="js/vendor-core.min.js"></script>
	<script src="js/vendor-tables.min.js"></script>
	<script src="js/vendor-forms.min.js"></script>
	<script src="js/vendor-maps.min.js"></script>
	<script src="js/module-essentials.min.js"></script>
	<script src="js/module-layout.min.js"></script>
	<script src="js/module-sidebar.min.js"></script>
	<script src="js/module-timeline.min.js"></script>
	<script src="js/module-chat.min.js"></script>
	<script src="js/module-maps.min.js"></script>
	<script src="js/theme-core.min.js"></script>
</body>
</html>