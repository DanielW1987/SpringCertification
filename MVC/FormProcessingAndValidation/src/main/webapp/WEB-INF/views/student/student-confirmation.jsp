<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student confirmation</title>
</head>
<body>
	<p>The student is confirmed: ${student.firstName} ${student.lastName} (${student.country})</p>
	<p>Free passes: ${student.freePasses}</p>
	<p>Postal code: ${student.postalCode}</p>
	<p>Course code: ${student.courseCode}</p>
	<p>Favorite programming language: ${student.favoriteLanguage}</p>
	<ul>
		<c:forEach var="temp" items="${student.osExperience}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>