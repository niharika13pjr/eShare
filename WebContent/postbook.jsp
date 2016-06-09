<%@ page import = "eshare.model.Registration" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
    <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${todo}" />
<fmt:setBundle basename="com.example.language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer" lang="${todo}">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script src="/New/WebContent/js/jquery-2.1.3.min.js"></script>
    <script src="/New/WebContent/js/jquery-2.1.3.min.js"></script>
    <style>
        .ui-autocomplete { 
            cursor:pointer; 
            height:120px; 
            overflow-y:scroll;
        }    
    </style>
<title>Book Sharing</title>
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
<%!
int userID;
String FirstName;
%>			<!-- we have to capture the userID from last jsp... -->
<!-- dsfasfadsfsdf -->

<body class="login">
	<div id="content">
		<div class="container-fluid">
			<div class="lock-container" style="width: 450px;">
				<h1>Enter the Book Information</h1>
				<div class="panel panel-default text-center"
					style="max-width: 450px ! important;">
					<img src="images/guy-5.jpg" class="img">
					<div class="panel-body">
						<form action="BookModulePostServlet" method="post">
							<table>
							 
								<tr>
								 
									<td><label for="booktitle"><fmt:message key="postbook.label.booktitle" /></label></td>
								<input type="hidden" name="userID" value="<%=userID %>">
									<td><input class="form-control" type="text" placeholder="Enter the name of the book" 
										name="booktitle"  id="tbCountries" /></td>
															
	
								</tr>
								<tr>
									<td><label for="isbn"><fmt:message key="postbook.label.isbn" /></label></td>
									<td><input class="form-control" type="text"
										placeholder="Enter ISBN number" name="ISBNnumber"></td>
								</tr>
								<tr>
									<td><label for="author"><fmt:message key="postbook.label.author" /></label></td>
									<td><input class="form-control" type="text"
										placeholder="Enter the author of the book" name="author"></td>
								</tr>
								<tr>
									<td><label for="publisher"><fmt:message key="postbook.label.publisher" /></label></td>
									<td><input class="form-control" type="text"
										placeholder="Enter the publisher of the book" name="publisher"></td>
								</tr>
								<tr>
									<td><label for="volume"><fmt:message key="postbook.label.volume" /></label></td>
									<td><input class="form-control" type="text"
										placeholder="Enter the addition volume of the book(if any)" name="additionVolume"></td>
								</tr>
								<tr>
									<td><label for="rentprice"><fmt:message key="postbook.label.rentprice" /></label></td>
									<td><input class="form-control" type="text"
										placeholder="Enter the price for rent" name="rentedPrice"></td>
								</tr>
								<tr>
									<td><label for="purchaseprice"><fmt:message key="postbook.label.purchaseprice" /></label></td>
									<td><input class="form-control" type="text"
										placeholder="Enter price for purchase" name="purchasePrice"></td>
								<tr>
									
								
		<tr>
									<td><label for="paymenttype"><fmt:message key="postbook.label.paymenttype" /></label></td>
									<td><input class="" type="radio" name="paymentType" value="Cash"> <label for="cashcash"><fmt:message key="postbook.label.cashpay" /></label>

										<input class="" type="radio" name="paymentType" value="Electronic Cash"><label for="ElecPayment"><fmt:message key="postbook.label.epay" /></label></td>
								</tr>

								<tr>
									<td><label for="comments"><fmt:message key="postbook.label.comments" /></label></td>
									<td><textarea class="form-control" name="comments"></textarea></td>
								</tr>
								<tr><fmt:message key="postbook.label.submit" var="buttonValuepostbook" />
								
								<tr>
									<td colspan="2"><input type="submit"
										class="btn btn-primary" name="submit" value="${buttonValuepostbook}"></td>
								</tr>
								
								<tr>
									<td><a href="home.jsp"><label for="returntohome"><fmt:message key="postbook.label.returnhome" /></label></a></td>
								</tr>
							</table>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
		
		  <script>
    $(document).ready(function() {
        BindControls();
    });

    function BindControls() {
        var Countries = ['ARGENTINA', 
            'AUSTRALIA', 
            'BRAZIL', 
            'BELARUS', 
            'BHUTAN',
            'CHILE', 
            'CAMBODIA', 
            'CANADA', 
            'CHILE', 
            'DENMARK', 
            'DOMINICA'];

        $('#tbCountries').autocomplete({
            source: Countries,
            minLength: 0,
            scroll: true
        }).focus(function() {
            $(this).autocomplete("search", "");
        });
    }
</script>
		  
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