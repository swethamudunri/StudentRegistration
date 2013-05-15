<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>
	<h1>WelCome to Well-Wish Traning Institute</h1>

	Register New student :
	<a href="registration.jsp"> Register New Student</a>
	<br> Get Registered Student Details :
	<a href="details.jsp">Get Registered Student Details</a>
	<br>Courses Offered :
	<a href="courses" />Courses offered
	</a>
</body>
</html>