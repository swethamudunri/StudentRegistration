<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration successful</title>
</head>
<body>
	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>
	<br>
	<br>
	<a href="welcome">Home</a>
	<br>
	<br> Registration done successfully
</body>
</html>