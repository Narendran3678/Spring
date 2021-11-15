package com.spring.Entity;

import com.spring.service.BusinessService;

public class Infosys implements BusinessService {

	public String organizationName;
	
	public int getEmployeeCount() {
		return 162000;
	}

	public String getSlogan() {
		return "Work Flexible";
	}

	public double getRevenue() {
		return 1620000.28;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationName() {
		return organizationName;
	}
}
