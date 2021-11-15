<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Model Attribute Validator</title>
</head>
<body>
	<h1>
		<c:out value="${headerMessage}"></c:out>
	</h1>
	<h3>
		Attribute 1 : <c:out value="${attribute1}"></c:out>
	</h3>
	<h3>
		Attribute 2 : <c:out value="${attribute2}"></c:out>
	</h3>
	<h3>
		Model And View Attribute : <c:out value="${modelAndViewAttribute}"></c:out>
	</h3>
	<h3>
		Organization : 
		<b>Name:</b> ${organization.companyName} <br />
		<b>Year:</b> ${organization.yearOfIncorporation} <br />
		<b>Zip:</b> ${organization.postalCode} <br />
		<b>Emp Count:</b> ${organization.employeeCount} <br />
		<b>Slogan:</b> ${organization.slogan} <br />
	</h3><br/>
	<h1>Value/Name Attribute</h1>
	<h3>
		Organization : 
		<b>Name:</b> ${org.companyName} <br />
		<b>Year:</b> ${org.yearOfIncorporation} <br />
		<b>Zip:</b> ${org.postalCode} <br />
		<b>Emp Count:</b> ${org.employeeCount} <br />
		<b>Slogan:</b> ${org.slogan} <br />
	</h3><br/>
	
</body>
</html>