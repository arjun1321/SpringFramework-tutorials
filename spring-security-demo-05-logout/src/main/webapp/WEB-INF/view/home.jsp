<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
		
		<!-- Adding a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="Logout"/>
			
		</form:form>
		
	</body>
</html>