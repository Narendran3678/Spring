<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h1>Welcome to Home Page</h1>
	<c:forEach var="row" items="${organizationList}">
		Name: ${row.companyName} <br/>
		Year: ${row.yearOfIncorporation} <br/>
		Zip: ${row.postalCode} <br/>
		Emp Count: ${row.employeeCount} <br/>
		Slogan: ${row.slogan} <br/><br/>
	</c:forEach>
</body>
</html>