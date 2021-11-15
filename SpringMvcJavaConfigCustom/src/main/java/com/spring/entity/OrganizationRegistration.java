package com.spring.entity;

public class OrganizationRegistration 
{
	private String orgName;
	private String country;
	private String turnover;
	private String type;
	private String serviceLength;
	private boolean registeredUser=false;
	private String like;
	private String[] serviceList;
	private String[] premiumServices;
	private String overseasOpertaion;
	private String employeeStrength;
	
	
	
	public String getOverseasOpertaion() {
		return overseasOpertaion;
	}
	public void setOverseasOpertaion(String overseasOpertaion) {
		this.overseasOpertaion = overseasOpertaion;
	}
	public String getEmployeeStrength() {
		return employeeStrength;
	}
	public void setEmployeeStrength(String employeeStrength) {
		this.employeeStrength = employeeStrength;
	}
	public String[] getPremiumServices() {
		return premiumServices;
	}
	public void setPremiumServices(String[] premiumServices) {
		this.premiumServices = premiumServices;
	}
	public String[] getServiceList() {
		return serviceList;
	}
	public void setServiceList(String[] serviceList) {
		this.serviceList = serviceList;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public boolean isRegisteredUser() {
		return registeredUser;
	}
	public void setRegisteredUser(boolean registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getServiceLength() {
		return serviceLength;
	}
	public void setServiceLength(String serviceLength) {
		this.serviceLength = serviceLength;
	}
	
	@Override
	public String toString() {
		return "OrganizationRegistration [orgName=" + orgName + ", country=" + country + ", turnover=" + turnover
				+ ", type=" + type + ", serviceLength=" + serviceLength + "]";
	}

	
}
