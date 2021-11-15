<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Result</title>
</head>
<body>
	<h1>
		<c:out value="${sessionResultMessage}"></c:out>
	</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h3> Session User Count : <c:out value="${sessionVisitorCount.count}"></c:out></h3>
	<h3> Request Attribute : ${requestAttributeVal} </h3>
	<c:if test="${sessionVisitorData.visitorList!=null}">
	<c:forEach var="visitor" items="${sessionVisitorData.visitorList}">
		Name  	: <c:out value="${visitor.name}"></c:out><br/>
		Email 	: <c:out value="${visitor.email}"></c:out><br/>
	</c:forEach><br/>
	</c:if>
	At Time : <c:out value="${currentTime}"></c:out>
	
	<h3>
		<a href="${contextPath}/sessionAttr/home">Go Back to Form</a>
	</h3>
	
</body>
</html>