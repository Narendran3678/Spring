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
	<form:form modelAttribute="organizationRegistration" action="orgRegForm">
		<table>
			<tr>
				<td>
					<form:label path="orgName">Organization Name</form:label>
				</td>
				<td>
					: ${organizationRegistration.orgName}
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="country">Country Name</form:label>
				</td>
				<td>
					: ${organizationRegistration.country}
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="country">Organization Turnover</form:label>
				</td>
				<td>
					: ${organizationRegistration.turnover}
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="type">Organization Type</form:label>
				</td>
				<td>
					: ${organizationRegistration.type}
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="serviceLength">Organization Service Length</form:label>
				</td>
				<td>
					:
					<c:forEach var="serLen" items="${orgServiceLength}">
						<c:if test="${serLen.key eq organizationRegistration.serviceLength}">
							${serLen.value}
						</c:if>
					 </c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="registeredUser">Registered User or Not</form:label>
				</td>
				<td>
					:
					<c:choose>
					<c:when test="${organizationRegistration.registeredUser eq true }">Registered User</c:when>
					<c:otherwise>Not a Registered User</c:otherwise>
					</c:choose> 
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="registeredUser">Registered User or Not</form:label>
				</td>
				<td>
					:
					<c:choose>
					<c:when test="${organizationRegistration.like eq 'yes' }">Page Liked</c:when>
					<c:otherwise>Disliked</c:otherwise>
					</c:choose> 
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="registeredUser">Promotion</form:label>
				</td>
				<td>
					:
					<c:forEach var="prom" items="${orgServiceList}">
						<c:forEach var="selProm" items="${organizationRegistration.serviceList}">
							<c:if test="${prom.key eq selProm}">
								<c:set var="concatprom" value="${concatprom}${prom.value},"/>
							</c:if>
						</c:forEach>
					</c:forEach>		
					${concatprom.substring(0,concatprom.length()-1)}	
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="premiumServices">Premium Services</form:label>
				</td>
				<td>
					:
					<c:forEach var="premiums" items="${orgPremiumServices}">
						<c:forEach var="selPremium" items="${organizationRegistration.premiumServices}">
							<c:if test="${premiums.key eq selPremium}">
								<c:set var="concatSelPremium" value="${concatSelPremium}${premiums.value},"/>
							</c:if>
						</c:forEach>
					</c:forEach>		
					${concatSelPremium.substring(0,concatSelPremium.length()-1)}	
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="overseasOpertaion">Overseas Operation</form:label>
				</td>
				<td>
					:
					<c:choose>
						<c:when test="${organizationRegistration.overseasOpertaion eq 'Yes'}">
							Domestic/International
						</c:when>
						<c:otherwise>Domestic</c:otherwise>
					</c:choose>
							
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="employeeStrength">Employee Strength</form:label>
				</td>
				<td>
					:
					<c:forEach var="empStrength" items="${orgEmployeeStrength}">
						<c:if test="${empStrength.key eq organizationRegistration.employeeStrength}">
							${empStrength.value}
						</c:if>
					</c:forEach>		
				</td>
			</tr>
			<tr>
				<td colspan="2">
	               <input type="submit" value="Go To Form"/>
	           </td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>