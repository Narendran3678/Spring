<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Organizaton List</title>
</head>
<body>
	<h1><c:out value="${headerMessage}"></c:out></h1>
	<h1><c:out value="${locationName}"></c:out> Organization List</h1>
	<c:forEach var="row" items="${organizationList}">
		<b>Name:</b> ${row.companyName} <br />
		<b>Year:</b> ${row.yearOfIncorporation} <br />
		<b>Zip:</b> ${row.postalCode} <br />
		<b>Emp Count:</b> ${row.employeeCount} <br />
		<b>Slogan:</b> ${row.slogan} <br />
		<br />
	</c:forEach>
</body>
</html>