<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>AdmissionPage</title>		
	</head>
	<body>		
		<h2>${welcome_msg}</h2>
		<hr />		
		<a id="en" href="/SpringMvcInternationalization/init?lang=en">English</a> | <a id="fr" href="/SpringMvcInternationalization/init?lang=fr">French</a>
		<div>&nbsp;</div>
		
		<div id="welcome_text">			
			<h4><spring:message code="welcome.message" /></h4>
		</div>
	</body>
</html>