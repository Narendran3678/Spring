<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>  
.error{color:red}  
</style>
<meta charset="ISO-8859-1">
<title>Form Validation</title>
</head>
<body>
	<form:form method="post" action="result" modelAttribute="organizationValidator">
		<table>
			<tr>
				<td>
					<form:label path="firstName">First Name</form:label>
				</td>
				<td>
					<form:input path="firstName"/>
					<form:errors path="firstName" cssClass="error"/>
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