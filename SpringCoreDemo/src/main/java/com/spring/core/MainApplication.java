package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication 
{
	public static void main(String args[])
	{
		//defaultCall();
		//customBeanFactory();
		//beanFactoryMethod();
		annotationBean();
	}
	public static void annotationBean()
	{
		System.out.println("Bean Factory Method");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		OrganizationAnnotation organizationAnnotation = (OrganizationAnnotation) context.getBean("organizationAnnotation");
		organizationAnnotation.getOrganizationInfo();
	}
	public static void customBeanFactory()
	{
		System.out.println("Bean Factory Method");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Organization organization = (Organization) context.getBean("organization-custom-2");
		organization.getOrganizationInfo();
	}
	public static void beanFactoryMethod()
	{
		System.out.println("Bean Factory Method");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Organization organization = (Organization) context.getBean("organization-custom-1");
		organization.getOrganizationInfo();
	}
	public static void defaultCall()
	{
		System.out.println("Default Call");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Organization organisation = (Organization) context.getBean("organization");
		Organization organisation1 = (Organization) context.getBean("organization");
		
		if(organisation==organisation1)
		{
			System.out.println("Singleton Scope");
		}
		else
		{
			System.out.println("Prototype Scope");
		}
		
		organisation1.setEmployeeName("Sam");
		organisation.getOrganizationInfo();
		System.out.println();
		organisation1.getOrganizationInfo();
	}
}

