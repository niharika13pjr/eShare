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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
currentg1 = 2; // This is input files added by default.
maxg1 = 5;
ming1 = 1;

function g1_app_child(){
    if(currentg1<maxg1)
    {
        var div = document.createElement("div");
        div.id = 'divfiles'+currentg1;
        /*div.style.width = "100px";
        div.style.height = "100px";
        div.style.background = "red";
        div.style.color = "white";*/
        div.innerHTML = '<input type="file" name="files['+currentg1+']" id="file'+currentg1+'" value="" />';
        document.getElementById('outer_div').appendChild(div);
        currentg1++;
        return false;
    }
    else
    {
        alert('Maximum '+maxg1+' Files are Allowed.');
        return false;
    }
}

function g1_delchild()
{
    if(currentg1>ming1)
    {
        cnt = currentg1-1;
        element = document.getElementById('divfiles'+cnt);
        element.parentNode.removeChild(element);
        currentg1--;
        return false;
    }
    else
    {
        alert('Minimum '+ming1+' Files are Allowed.');
        return false;
    }
}
</script>

</head>
<body>
<!--  <div class="panel-body"> -->
                   		<form action="<%= request.getContextPath() %>/UploadServlet" method="post" enctype="multipart/form-data">
                    
                        <input class="form-control" type="file" placeholder="Select File..." name="dp" value= "test">
<!--                         <input class="form-control" type="email" name="resume" placeholder="SelectFile..."> -->
<fmt:message key="fileupload.button.submit" var="buttonValue2" />
                                                                
							<tr>
									<td colspan="2"><input type="submit"
										class="btn btn-primary" name="submit" value="${buttonValue2}"></td>
								</tr>						
                        
                        
                        
                       </form>
<!--                     </div> -->

</body>
</html>