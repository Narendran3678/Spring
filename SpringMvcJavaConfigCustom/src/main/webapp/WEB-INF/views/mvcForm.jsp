<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MVC Form</title>
</head>
<body>
	<h1>
		<c:out value="${headerMessage}"></c:out>
	</h1>
	<h1><c:out value="Mvc Form"></c:out></h1>
	<form:form modelAttribute="organizationForm" method="post" action="orgMvcForm">
		<table>
			<tr>
				<td>
					<form:label path="companyName">Company Name</form:label>
				</td>
				<td>
					<form:input path="companyName"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="yearOfIncorporation">Years of Incorporation</form:label>
				</td>
				<td>
					<form:input path="yearOfIncorporation"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="postalCode">Postal Code</form:label>
				</td>
				<td>
					<form:input path="postalCode"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="employeeCount">Employee Count</form:label>
				</td>
				<td>
					<form:input path="employeeCount"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="slogan">slogan</form:label>
				</td>
				<td>
					<form:input path="slogan"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
	               <input type="submit" value="Save Changes"/>
	           </td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>