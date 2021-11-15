package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.service.BusinessService;

public class OrganizationAnnotation 
{
	private String employeeName;
	
	BusinessService businessService;
	public OrganizationAnnotation()
	{
		
	}
	@Autowired
	public OrganizationAnnotation(BusinessService businessService)
	{
		System.out.println("Constructor Injection");
		this.businessService = businessService;
	}
	public void getOrganizationInfo()
	{
		System.out.println("Name : "+businessService.getOrganizationName());
		System.out.println("Employee Count : "+businessService.getEmployeeCount());
		System.out.println("Revenue : "+businessService.getRevenue());
		System.out.println("Slogan : "+businessService.getSlogan());
		System.out.println("EmployeeName : "+getEmployeeName());
	}
	public String getEmployeeName() {
		return employeeName;
	}
	@Autowired
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public BusinessService getBusinessService() {
		return businessService;
	}
	@Autowired
	public void setBusinessService(BusinessService businessService) {
		System.out.println("Setter Injection");
		this.businessService = businessService;
	}
	
}
