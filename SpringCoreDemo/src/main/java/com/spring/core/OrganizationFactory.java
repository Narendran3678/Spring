package com.spring.core;

import com.spring.service.BusinessService;

public class OrganizationFactory 
{
	public Organization createInstance(BusinessService businessService)
	{
		return new Organization(businessService);
	}
}
