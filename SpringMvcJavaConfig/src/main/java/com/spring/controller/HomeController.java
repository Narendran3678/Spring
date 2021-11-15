package com.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.OrganizationService;

@Controller
public class HomeController 
{
	@Autowired
	OrganizationService organizationService;
	@RequestMapping("/")
	public String listOfOrganization(Model model)
	{
		model.addAttribute("organizationList",organizationService.getAllOrganization());
		System.out.println(organizationService.getAllOrganization());
		return "organization";
	}
}
