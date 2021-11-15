package com.spring.controller;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.entity.Organization;
import com.spring.service.OrganizationService;

@Controller
public class HomeController 
{
	private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	OrganizationService organizationService;
	@RequestMapping("/organizations")
	public String listOfOrganization(Model model)
	{
		model.addAttribute("organizationList",organizationService.getAllOrganization());
		return "organization";
	}
	@RequestMapping("/locationForm")
	public String location(Model model)
	{
		return "locationName";
	}
	@RequestMapping("/validator1")
	public String requestMappingValidation(@RequestParam(value="organizationName") String orgName ,Model model)
	{
		LOGGER.info("requestMappingValidation - "+orgName);
		model.addAttribute("organizationName",orgName);
		model.addAttribute("screenName","validator1");
		return "requestMappingValidation";
	}
	
	@RequestMapping(value="/validator2" , params="organizationName")
	public String requestMappingValidationOrgName(@RequestParam String organizationName ,Model model)
	{
		LOGGER.info("requestMappingValidationOrgName - "+organizationName);
		model.addAttribute("organizationName",organizationName);
		model.addAttribute("screenName","validator2OrgName");
		return "requestMappingValidation";
	}
	@RequestMapping(value="/validator2" , params="empCount")
	public String requestMappingValidationEmpCount(@RequestParam String empCount ,Model model)
	{
		LOGGER.info("requestMappingValidationEmpCount - "+empCount);
		model.addAttribute("eCount",empCount);
		model.addAttribute("screenName","validator2EmpCount");
		return "requestMappingValidation";
	}
	@RequestMapping(value={"/validator3","/validator4"} , params={"organizationName","empCount"})
	public String requestMappingValidationMutliParam(@RequestParam String organizationName,@RequestParam String empCount ,Model model,HttpServletRequest request)
	{
		LOGGER.info("requestMappingValidationMutliParam -> organizationName-"+organizationName+", empCount-"+empCount+", URL-"+request.getRequestURL());
		model.addAttribute("eCount",empCount);
		model.addAttribute("organizationName",organizationName);
		if(request.getRequestURL().toString().contains("validator3"))
			model.addAttribute("screenName","validator3");
		else
			model.addAttribute("screenName","validator4");
		return "requestMappingValidation";
	}
	/*@RequestMapping(value="*", method = RequestMethod.GET)
	public String fallBack()
	{
		return "fallBack";
	}*/
	@RequestMapping("/modelAttributeValidator")
	public ModelAndView getModelAndView(Model model)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeValidator");
		mav.addObject("modelAndViewAttribute", " Test Model and View Attribute");
		return mav;
	}
	@RequestMapping("/mvcForm")
	public ModelAndView getMvcForm(Model model)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mvcForm");
		mav.addObject("organizationForm",new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history"));
		return mav;
	}
	@RequestMapping("/orgMvcForm")
	public ModelAndView getOrgMvcForm(@ModelAttribute Organization organizationForm,Model model)
	{
		LOGGER.info("Organization - "+organizationForm.toString());
		ModelAndView mav = new ModelAndView("DispOrgForm");
		mav.addObject("organization", organizationForm);
		return mav;
	}
	
	@ModelAttribute
	public void getOrganizationModelAttribute1(Model model)
	{
		LOGGER.info("ModelAttribute1");
		model.addAttribute("organization",new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history"));
	}
	@ModelAttribute
	public void modelAttribute1(Model model)
	{
		LOGGER.info("ModelAttribute1");
		model.addAttribute("attribute1","Test Attribute 1");
	}
	@ModelAttribute(name="attribute2")
	public String modelAttribute2(Model model)
	{
		LOGGER.info("modelAttribute2");
		return "Test Attribute 2";
	}
	@ModelAttribute(value="org")
	public Organization getOrganizationModelAttributeValue(Model model)
	{
		LOGGER.info("getOrganizationModelAttributeValue");
		return new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
	}

}
