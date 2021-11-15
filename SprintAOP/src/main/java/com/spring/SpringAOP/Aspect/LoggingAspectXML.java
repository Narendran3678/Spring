package com.spring.SpringAOP.Aspect;

public class LoggingAspectXML 
{
	public void beforeMethod()
	{
		System.out.println("Before Method Called");
	}
	public void afterMethod()
	{
		System.out.println("After Method Called");
	}
}
