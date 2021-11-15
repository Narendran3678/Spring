package com.spring.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.spring.doa.impl.OrganizationDAOImplNamedTemplate;
import com.spring.entity.Organization;

@Service
public class OrganizationService 
{
	@Value("#{orgServiceLength}")
	public Map<String,String> orgServiceLength;
	@Autowired
	OrganizationDAOImplNamedTemplate organizationDAOImplNamedTemplate;
	public OrganizationService(){}
	public List<Organization> getAllOrganization()
	{
		return organizationDAOImplNamedTemplate.getAllOrganization();
	}
	public Map<String, String> populateTurnover() {
		Map<String, String> turnover = new LinkedHashMap<String, String>();
		turnover.put("none", "-----SELECT-----");
		turnover.put("1000",  "Less than $1,000");
		turnover.put("10000",  "Greater than $1,000 but less than $10,000");
		turnover.put("100000",  "Greater than $10,000 but less than $100,000");
		return turnover;
	}
	public Map<String,String> getSectorType()
	{
		Map<String, String> type = new LinkedHashMap<String, String>();
		type.put("none", "-----SELECT-----");
		type.put("gov",  "Government");
		type.put("semigov",  "Semi Government");
		type.put("private",  "Private");
		return type;
	}
	public Map<String,String> getRegisterUser()
	{
		Map<String, String> registerUser = new LinkedHashMap<String, String>();
		registerUser.put("true", "Yes");
		registerUser.put("false", "No");
		return registerUser;
	}
	public Map<String,String> getServiceList()
	{
		Map<String, String> serviceList = new LinkedHashMap<String, String>();
		serviceList.put("emailPromotion", "Email Promotion");
		serviceList.put("tvPromotion", "Tv Promotion");
		serviceList.put("socialMediaPromotion", "Social Media Promotion");
		return serviceList;
	}
	public Map<String,String> getPremiumServices()
	{
		Map<String, String> premiumServices = new LinkedHashMap<String, String>();
		premiumServices.put("directoryService", "Directory Service");
		premiumServices.put("revenueReport", "Revenue Report");
		premiumServices.put("revenueAnalytics", "Revenue Analytics");
		return premiumServices;
	}
	public Map<String,String> getEmployeeStrength()
	{
		Map<String, String> overseas = new LinkedHashMap<String, String>();
		overseas.put("small", "Less than 1000");
		overseas.put("medium", "Less than 10000 greater than 1000");
		overseas.put("large", "Greater than 6000");
		return overseas;
	}
	public Map<String,String> getOrgServiceLength()
	{
		return new TreeMap<String,String>(orgServiceLength);
	}
}
