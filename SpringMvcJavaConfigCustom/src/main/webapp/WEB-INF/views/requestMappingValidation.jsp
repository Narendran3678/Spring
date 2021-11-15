<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Mapping Validation</title>
</head>
<body>
	<h1><c:out value="${headerMessage}"></c:out></h1>
	<h2>Screen Name : <c:out value="${screenName}"/></h2>
	<h3>Organization Name : <c:out value="${organizationName}"/></h3>
	
	<h3>Printing Parameter by Iterating</h3>
	<c:forEach var="parameter" items="${param}">
		<c:out value="${parameter.key}"></c:out> = <c:out value="${parameter.value}"></c:out>
	</c:forEach>
	
</body>
</html>