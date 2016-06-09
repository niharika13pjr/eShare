<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
        <title>Share It - Select Demo</title>
        <meta name="description" content="Select your preview">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="CrayThemes">
        <link rel="shortcut icon" href="http://themes.cray.bg/share-it/wp-content/themes/shareit/images/favicon.ico">
        <!-- Retina iPad Touch Icon-->
        <link rel="apple-touch-icon" sizes="144x144" href="http://themes.cray.bg/share-it/wp-content/themes/shareit/images/favicon.ico">
        <!-- Retina iPhone Touch Icon-->
        <link rel="apple-touch-icon" sizes="114x114" href="http://themes.cray.bg/share-it/wp-content/themes/shareit/images/favicon.ico">
        <!-- Standard iPad Touch Icon--> 
        <link rel="apple-touch-icon" sizes="72x72" href="http://themes.cray.bg/share-it/wp-content/themes/shareit/images/favicon.ico">
        <!-- Standard iPhone Touch Icon--> 
        <link rel="apple-touch-icon" sizes="57x57" href="http://themes.cray.bg/share-it/wp-content/themes/shareit/images/favicon.ico">
        
        <!-- =============== Google fonts =============== -->
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700' rel='stylesheet' type='text/css'>
        

        <!-- ============== Resource style ============== -->
		<link rel="stylesheet" href="css/style-2.css">

		<!-- Modernizr runs quickly on page load to detect features -->
		<script src="js/modernizr.js"></script>
    </head>

	<body>

		
		<div class="list-sections animated-middle">

			<ul>

				<li class="item-list"> <!-- 1 / .who part -->

					<!-- Link to open the popup -->
					<a href="FoodModuleViewServlet" class="open-popup-link">
				
						<div class="item-title">
					<h2><span class="point" style="color:#72c14c;"><label for="get"><fmt:message key="foodmodule.label.get" /></label> </span> <strong><label for="food"><fmt:message key="foodmodule.label.food" /></label></strong></h2>
						</div> <!-- .item-title -->

						<div class="item-plus"><p><label for="getSomeones"><fmt:message key="foodmodule.label.getSomeones" /></label><br><label for="clickAvailable"><fmt:message key="foodmodule.label.clickAvailable" /></label></p><br>
                            <svg version="1.1" id="Layer_1" width="60px" height="60px" viewBox="0 0 300 300" style="enable-background:new 0 0 300 300;" xml:space="preserve">
                                                    <line style="stroke:#bdb4ac;" class="st0" x1="150.881" y1="36.392" x2="150.881" y2="259.611"/>
                                                    <line style="stroke:#bdb4ac;" class="st0" x1="39.271" y1="148.001" x2="262.49" y2="148.001"/>
                                                </svg></div>

					</a>

				</li> <!-- .who part -->

				<li class="item-list"> <!-- 2 / .when part -->

					<!-- Link to open the popup -->
					<a href="postfood.jsp" class="open-popup-link">
				
						<div class="item-title">
                              <h2><span class="point" style="color:#72c14c;"><label for="share"><fmt:message key="foodmodule.label.share" /></label> </span> <strong><label for="food"><fmt:message key="foodmodule.label.food" /></label></strong></h2>
						</div> <!-- .item-title -->

					<div class="item-plus"><p><label for="shareYours1"><fmt:message key="foodmodule.label.ShareFood" /></label><br><label for="clickEnterCloth"><fmt:message key="foodmodule.label.clickEnterFood" /></label></p><br>
							<svg version="1.1" id="Layer_1" width="60px" height="60px" viewBox="0 0 300 300" style="enable-background:new 0 0 300 300;" xml:space="preserve">
                                                    <line style="stroke:#72c14c;" class="st0" x1="150.881" y1="36.392" x2="150.881" y2="259.611"/>
                                                    <line style="stroke:#72c14c;" class="st0" x1="39.271" y1="148.001" x2="262.49" y2="148.001"/>
                                                </svg></div>

					</a>
				
				</li> <!-- .when part -->

                                			</ul>			

		</div> <!-- .list-sections -->

		
		<!-- ///////////////////\\\\\\\\\\\\\\\\\\\ -->
        <!-- ********** Resources jQuery ********** -->
        <!-- \\\\\\\\\\\\\\\\\\\/////////////////// -->

		<!-- * Libraries jQuery and Bootstrap - Be careful to not remove them * -->
		<script src="js/jquery-2.1.3.min.js"></script>
		
  

		<!-- Main Js -->
		<script src="js/main.js"></script>

	</body>


<!-- Mirrored from themes.cray.bg/themeswitch/share-it/ by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 11 Feb 2016 23:37:36 GMT -->
</html>