package com.spring.entity;
import javax.validation.constraints.*;

public class OrganizationValidator 
{
	@NotBlank(message="Cannot be Empty")
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "OrganizationValidator [firstName=" + firstName + "]";
	}
	
}
