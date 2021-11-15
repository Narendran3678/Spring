package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.doa.impl.OrganizationDAOImplNamedTemplate;
import com.spring.entity.Organization;

@Service
public class OrganizationService {
	@Autowired
	OrganizationDAOImplNamedTemplate organizationDAOImplNamedTemplate;
	public OrganizationService(){}
	public List<Organization> getAllOrganization()
	{
		return organizationDAOImplNamedTemplate.getAllOrganization();
	}
}
