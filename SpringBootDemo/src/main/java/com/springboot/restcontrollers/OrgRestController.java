package com.springboot.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Organization;
import com.springboot.services.DaoServices;

@RestController
@RequestMapping("/org")
public class OrgRestController 
{
	@Autowired
	DaoServices daoServices;
	
	@GetMapping("/organization")
	public List<Organization> getOrganizationList()
	{
		
		return daoServices.findAll();
	}
}
