<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Details</title>
</head>
<body>
	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>
	<br>
	<br>
	<a href="welcome">Home</a>
	<br> Student Details
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th><c:out value="ID" /></th>
			<th><c:out value="NAME" /></th>
			<th><c:out value="COURSE" /></th>
		</tr>
		<tr>
			<td><c:out value="${studentServices.id}" /></td>
			<td><c:out value="${studentServices.name}" /></td>
			<td><c:out value="${studentServices.course}" /></td>

		</tr>
	</table>
</body>
</html>