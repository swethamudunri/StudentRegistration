<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses Details</title>
</head>
<body>
	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>
	<a href="welcome">Home</a>
	<br> Following Courses Offered

	<table border="1" cellpadding="2" cellspacing="2">
		<tr>

			<th><c:out value="COURSE" /></th>
		</tr>
		<c:forEach var="stud" items="${courses}">
			<tr>
				<td><c:out value="${stud}" /></td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>