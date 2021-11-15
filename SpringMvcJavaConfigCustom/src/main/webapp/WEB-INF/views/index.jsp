<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1><c:out value="${headerMessage}"></c:out></h1>
	<h1>Orgranization Index Page</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<ul>
		<li>
			<a href="${contextPath}/locationForm">Go to Location Page</a>
		</li>
		<li>
			<a href="${contextPath}/sessionAttr/home">Go to Session Attribute</a>
		</li>
		<li>
			<a href="${contextPath}/sessionAttr/orgRegForm">Go to Organization Registration Form</a>
		</li>
		<li>
			<a href="${contextPath}/mvcValiatorForm/home">Go to Organization Validator Form</a>
		</li>
	</ul>
</body>
</html>