package com.springboot.customException;


@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException
{
	public CourseNotFoundException(String message) 
	{
		super(message);
	}
	
}
