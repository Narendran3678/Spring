package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.Organization;

public class MainApplication 
{
	public static void main(String args[])
	{
		System.out.println("Bean Factory Method");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Organization organization = (Organization) context.getBean("organization");
		organization.getEmployeeInformation();
		((ClassPathXmlApplicationContext)context).close();
	}
}

