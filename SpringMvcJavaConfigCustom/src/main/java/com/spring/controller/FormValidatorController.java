package com.spring.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring.entity.OrganizationValidator;

@Controller
public class FormValidatorController 
{
	private static Logger LOGGER = LoggerFactory.getLogger(FormValidatorController.class);
	
	@RequestMapping("/mvcValiatorForm/home")
	public ModelAndView formValidator()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("organizationValidator", new OrganizationValidator());
		mav.setViewName("mvcValidatorForm");
		return mav;
	}
	@RequestMapping("/mvcValiatorForm/result")
	public ModelAndView formValidatorResult(@Valid @ModelAttribute OrganizationValidator organizationValidator,BindingResult result,Model model)
	{
		ModelAndView mav=new ModelAndView();
		LOGGER.info("Error-"+result.hasErrors());
		if(result.hasErrors())
		{
			mav.addObject("formError",result.getAllErrors());
			//mav.addObject("organizationValidator",new OrganizationValidator());
			mav.setViewName("mvcValidatorForm");
		}
		else
		{
			mav.addObject("organizationValidator",organizationValidator);
			mav.setViewName("mvcValidatorFormResult");	
		}
		return mav;
	}
}
