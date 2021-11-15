package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.Entity.Employee;

@Component
public class Organization 
{
	Employee employee;
	public Organization()
	{
		
	}
	@Autowired
	public Organization(Employee employee)
	{
		this.employee =  employee;
	}	
	public void getEmployeeInformation()
	{
		System.out.println(employee.toString());
	}
	
}
