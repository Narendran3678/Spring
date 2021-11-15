<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Organization Registration</title>
</head>
<body>
	<h1>
		<c:out value="${headerMessage}"></c:out>
	</h1>
	<h1><c:out value="Mvc Form"></c:out></h1>
	<form:form modelAttribute="organizationRegistration" method="post" action="orgRegResult">
		<table>
			<tr>
				<td>
					<form:label path="orgName">Organization Name</form:label>
				</td>
				<td>
					<form:input path="orgName"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="country">Country Name</form:label>
				</td>
				<td>
					<form:select path="country">
						<form:option value="NONE">--SELECT--</form:option>
						<form:option value="India">India</form:option>
						<form:option value="Australia">Australia</form:option>
						<form:option value="England">England</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="turnover">Company TurnOver</form:label>
				</td>
				<td>
					<form:select path="turnover">
						<form:options items="${orgTurnover}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="type">Company Type</form:label>
				</td>
				<td>
					<form:select path="type" items="${orgType}"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="serviceLength">Company Service Length</form:label>
				</td>
				<td>
					<form:select path="serviceLength" items="${orgServiceLength}"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="registeredUser">Registered</form:label>
				</td>
				<td>
					<form:checkbox path="registeredUser" items="${orgRegisterUser}"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="like">Like</form:label>
				</td>
				<td>
					<form:checkbox path="like" value="yes"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="serviceList">Promotion</form:label>
				</td>
				<td>
					<form:checkbox path="serviceList" value="emailPromotion"/>${orgServiceList.emailPromotion}
					<form:checkbox path="serviceList" value="tvPromotion"/>${orgServiceList.tvPromotion}
					<form:checkbox path="serviceList" value="socialMediaPromotion"/>${orgServiceList.socialMediaPromotion}
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="premiumServices">Premium Services</form:label>
				</td>
				<td>
					<form:checkboxes path="premiumServices" items="${orgPremiumServices}"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="overseasOpertaion">Overseas Operation</form:label>
				</td>
				<td>
					<form:radiobutton path="overseasOpertaion" value="Yes"/>Yes
					<form:radiobutton path="overseasOpertaion" value="No"/>No
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="employeeStrength">Employee Strength</form:label>
				</td>
				<td>
					<form:radiobuttons path="employeeStrength" items="${orgEmployeeStrength}"/>
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