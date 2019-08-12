<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
	<head>
		<title>Arjun Kumar Home Page</title>
	</head>
	
	<body>
		<h1>Arjun Kumar Home Page</h1>
		<hr>
		
		<p>
		Welcome to the home page
		</p>
		
		<!-- Display username and role -->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>		
			Role(s): <security:authentication property="principal.authorities" />
			
		</p>
		
		<!-- Adding a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="Logout"/>
			
		</form:form>
		
	</body>
</html>