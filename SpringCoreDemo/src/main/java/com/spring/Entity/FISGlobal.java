package com.spring.Entity;

import com.spring.service.BusinessService;

public class FISGlobal implements BusinessService {

	public String organizationName;
	
	public int getEmployeeCount() {
		return 62000;
	}

	public String getSlogan() {
		return "Work Hard and Work Smart";
	}

	public double getRevenue() {
		return 620000.28;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

}
