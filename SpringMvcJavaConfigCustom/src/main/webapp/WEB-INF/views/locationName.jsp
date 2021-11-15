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
	<h3>Enter Location Name</h3>
	<form name="locationForm" action="organizations">
		<input type="text" name="locationName"/>
		<input type="submit" value="List Organization">
	</form><br/>
	<form name="validator1" action="validator1">
		<input type="text" name="organizationName"/>
		<input type="submit" value="Send Organization">
	</form><br/>
	<form name="validator2" action="validator2">
		<input type="text" name="organizationName"/>
		<input type="submit" value="Submit">
	</form><br/>
	<h3>Multi Request</h3>
	<form name="validator3" action="validator3">
		OrganizationName: <input type="text" name="organizationName"/><br/>
		EmpCount: <input type="text" name="empCount"/>
		<input type="submit" value="Submit">
	</form><br/>
	<h3>Model Attribute</h3>
	<form name="modelAttributeValidator" action="modelAttributeValidator">
		<input type="submit" value="Test Model Attribute">
	</form>
	
	<h3>MVC Test Form</h3>
	<form name="mvcForm" action="mvcForm">
		<input type="submit" value="MVC Form">
	</form>
</body>
</html>