<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Form</title>
</head>
<body>
	<h1>
		<c:out value="${sessionWelcomeMessage}"></c:out>
	</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="formData" modelAttribute="visitorData">
		<table>
			<tr>
				<td>
					<form:label path="visitorName">Visitor Name</form:label>
				</td>
				<td>
					<form:input path="visitorName"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="visitorMail">Visitor Mail</form:label>
				</td>
				<td>
					<form:input path="visitorMail"/>
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form:form>
	<form:form action="${contextPath}/sessionAttr/sessionClear">
		<input type="submit" value="Clear Session"/>
	</form:form>
</body>
</html>