package com.spring.core;

import com.spring.service.BusinessService;

public class Organization 
{
	private String employeeName;
	BusinessService businessService;
	public Organization(BusinessService businessService)
	{
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
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public static Organization getInstance(BusinessService businessService)
	{
		return new Organization(businessService);
	}
}
