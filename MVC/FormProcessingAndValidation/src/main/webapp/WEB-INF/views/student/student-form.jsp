<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
<style>
	.error{color:red}
</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" /><br />
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" /><br />
		Free passes (*): <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" /><br />
		Postal code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" /><br />
		Course code: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" /><br />
		
		Country:   
		<form:select path="country" items="${student.countryOptions}">
			<!-- <form:option value="Germany" label="Germany" />
			<form:option value="U.S." label="U.S." />
			<form:option value="France" label="France" /> -->
		</form:select><br /><br />
		
		Country (from properties file):
		<form:select path="country"> 
		 <form:options items="${otherCountryOptions}" />
		</form:select>
		
		<br /><br />
		
		Favorite Programming Language:
		<form:radiobuttons path="favoriteLanguage" items="${student.programmingLanguages}"/>
		<!-- Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		Python <form:radiobutton path="favoriteLanguage" value="Python" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" /> -->
		
		<br /><br />
		
		Experiences in OS:
		Linux <form:checkbox path="osExperience" value="Linux"/>
		Windows <form:checkbox path="osExperience" value="Windows"/>
		Mac OS<form:checkbox path="osExperience" value="Mac OS"/>
		
		<br /><br />
		
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>