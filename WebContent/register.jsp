<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.todo : not empty todo ? todo : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${todo}" />
<fmt:setBundle basename="com.example.language.text" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Register</title>
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
<script type="text/javascript">
	function a() {
		var x = document.getElementById("pd");
		var y = document.getElementById("rpd");
		submitok = "true";
		if (x.value == "") {
			alert("Enter Password");
			submitok = "false";
		}
		if (y.value == "") {
			alert("Enter Re-type Password");
			submitok = "false";
		}
		if (x.value != y.value) {
			alert("Password and  Re-type Password are not match");
			submitok = "false";
		} else {
			window.location.reload();
		}
	}
</script>
</head>
<body class="login">
	<div id="content">
		<div class="container-fluid">
			<div class="lock-container" style="width: 450px;">
				<h1>Register Now</h1>
				<form>
				<head>
                <font size="3" color="white"><h>Select Language</h></font>
                </head><br>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${todo == 'en' ? 'selected' : ''}>English</option>
                <option value="nl" ${todo == 'nl' ? 'selected' : ''}>Nederlands</option>
                <option value="es" ${todo == 'es' ? 'selected' : ''}>Espa�ol</option>
             </select>
        </form>

				<div class="panel panel-default text-center"
					style="max-width: 450px ! important;">
					<img src="images/guy-5.jpg" class="img">
					<div class="panel-body">
					
						<form action="RegistrationServlet" method="post"
							onsubmit="a()">
								<table>
								<tr>
										<td><label for="firstname"><fmt:message key="login.label.firstname" />:</label></td>
									<td><input class="form-control" type="text"
										placeholder="First Name" name="fname"></td>
								</tr>
								<br>
								<tr>
								<td><label for="lastname"><fmt:message key="login.label.lastname" />:</label></td>
									<td><input class="form-control" type="text"
										placeholder="Last Name" name="lname"></td>
								</tr>
								<tr>
									<td><label for="dob"><fmt:message key="login.label.dob" />:</label> </td>
									<td><input class="form-control" type="date"
										placeholder="Date of Birth" name="dob"></td>
								<tr>
									<td><label for="address"><fmt:message key="login.label.address" />:</label></td>
									<td><input class="form-control" type="text"
										placeholder="Lives in" name="Address"></td>
								</tr>
								<tr>
									<td><label for="contact"><fmt:message key="login.label.contact" />:</label></td>
									<td><input class="form-control" type="text"
										placeholder="Contact No." name="Contact"></td>
								</tr>
								<tr>
									<td><label for="gender"><fmt:message key="login.label.Gender" />:</label></td>
									<td><input class="" type="radio" name="gender" value="Male"><label for="malegender"><fmt:message key="login.label.malegender" />:</label>

										<input class="" type="radio" name="gender" value="Female"><label for="femalegender"><fmt:message key="login.label.femalegender" />:</label></td>
								</tr>
								<!--   File Upload   -->
								<tr>
									<td><label for="profilepic"><fmt:message key="login.label.profilepic" />:</label></td>
									<td><iframe
											style="width: 258px; height: 85px; border: none"
											src="fileupload.jsp"></iframe></td>
								</tr>
								<tr>
									<td><label for="email"><fmt:message key="login.label.email" />:</label></td>
									<td><input class="form-control" type="email"
										placeholder="Email" name="Email"></td>
								</tr>
								<tr>
									<td><label for="username"><fmt:message key="login.label.username" />:</label></td>
									<td><input class="form-control" type="text"
										placeholder="User ID" name="userID"></td>
								</tr>
								<tr>
									<td><label for="password"><fmt:message key="login.label.password" />:</label></td>
									<td><input class="form-control" type="password"
										placeholder="Password" id="pd" name="password"></td>
								</tr>
								<tr>
									<td><label for="repassword"><fmt:message key="login.label.repassword" />:</label></td>
									<td><input class="form-control" type="password"
									
										placeholder="Re-type Password" id="rpd" name="rpd"></td>
								</tr>
								
								<fmt:message key="login.button.submit" var="buttonValue" />
                                           
                                            
							<tr>
									<td colspan="2"><input type="submit"
										button class="btn btn-primary" name="submit" value="${buttonValue}"></td>
								</tr>
							</table>

						</form>
					</div>
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