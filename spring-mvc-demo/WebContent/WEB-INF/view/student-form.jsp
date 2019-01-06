<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Doctype html>

<html>

	<head>
		<title>Student Registration Form</title>
	</head>
	
	<body>
		
		<form:form action="processForm" modelAttribute="student">
			
			First Name: <form:input path="firstName" />
			
			<br><br>
			
			Last Name: <form:input path="lastName" />
			
			<br><br>
			
			Country: 
			
			<form:select path="country">
			
			<!--  Comments
				<form:option value="Brazil" label="Brazil" />
				<form:option value="France" label="France" />
				<form:option value="Germany" label="Germany" />
				<form:option value="India" label="India" />	
			-->
			
				<form:options items="${student.countryOptions }"/>
			
			</form:select>
			
			<br><br>
			
			Favorite Language:
			
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
			
			<br><br>
			
			Operating systems:
			
			Linux <form:checkbox path="operatingSystem" value="Linux" />
			Mac Os <form:checkbox path="operatingSystem" value="Mac Os" />
			MS Windows <form:checkbox path="operatingSystem" value="MS Windows" />
			
			<br><br>
			
			<input type="submit" value="Submit" />
		
		</form:form>
		
		
	</body>
</html>