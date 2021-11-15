package com.spring.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.OrganizationRegistration;
import com.spring.entity.OrganizationValidator;
import com.spring.entity.Visitor;
import com.spring.entity.VisitorCount;
import com.spring.entity.VisitorData;
import com.spring.service.OrganizationService;
import com.spring.service.SessionService;

@Controller
@RequestMapping("/sessionAttr")
@SessionAttributes(names= {"sessionVisitorData","sessionVisitorCount"})
public class SessionController 
{
	private static Logger LOGGER = LoggerFactory.getLogger(SessionController.class);
	@Autowired
	SessionService sessionService;
	@Autowired
	OrganizationService organizationService;
	@RequestMapping("/home")
	public ModelAndView sessionHome()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("visitorData", new VisitorData());
		mav.setViewName("sessionAttr/sessionForm");
		return mav;
	}
	@RequestMapping("/formData")
	public ModelAndView sessionForm(@ModelAttribute("visitorData") VisitorData currentVisitor,
			@RequestAttribute("requestAttributeVal") String reqAttributeVal,
			@SessionAttribute("currentTime") LocalDateTime currentTime,SessionStatus sessionStatus,
			HttpSession session)
	{
		VisitorData sessionVisitorData 	= (VisitorData)session.getAttribute("sessionVisitorData");
		VisitorCount visitorCount 		= (VisitorCount)session.getAttribute("sessionVisitorCount");
		if(sessionVisitorData!=null)
			sessionService.visitorRegistry(sessionVisitorData, currentVisitor);
		if(visitorCount!=null)
			sessionService.visitorCountUpdate(visitorCount);
		LOGGER.info("sessionVisitorData - "+sessionVisitorData);
		LOGGER.info("visitorCount - "+visitorCount);
		LOGGER.info("reqAttributeVal -"+reqAttributeVal);
		LOGGER.info("currentTime - "+currentTime);
		ModelAndView mav=new ModelAndView();
		mav.addObject("visitorData", new VisitorData());
		mav.addObject("requestAttributeVal", reqAttributeVal);
		mav.addObject("currentTime", Duration.between(currentTime, LocalDateTime.now()).getSeconds());
		mav.setViewName("sessionAttr/sessionResult");
		return mav;
	}
	@RequestMapping("/sessionClear")
	public ModelAndView sessionClear(HttpSession session,SessionStatus sessionStatus)
	{
		sessionStatus.setComplete();
		session.invalidate();
		ModelAndView mav=new ModelAndView();
		mav.addObject("visitorData", new VisitorData());
		mav.setViewName("sessionAttr/sessionForm");
		return mav;
	}
	@RequestMapping("/orgRegForm")
	public ModelAndView organizationRegistrationForm(Model model)
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("organizationRegistration", new OrganizationRegistration());
		mav.setViewName("organizationRegistration");
		return mav;
	}
	@RequestMapping("/orgRegResult")
	public ModelAndView organizationRegistrationResult(@ModelAttribute("organizationRegistration") OrganizationRegistration organizationRegistration, Model model)
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("organizationRegistration", organizationRegistration);
		mav.setViewName("organizationRegistrationResult");
		return mav;
	}
	
	@ModelAttribute
	public void mvcFormValue(Model model)
	{
		model.addAttribute("orgTurnover",organizationService.populateTurnover());
		model.addAttribute("orgType",organizationService.getSectorType());
		model.addAttribute("orgServiceLength",organizationService.getOrgServiceLength());
		model.addAttribute("orgRegisterUser",organizationService.getRegisterUser());
		model.addAttribute("orgServiceList",organizationService.getServiceList()); 
		model.addAttribute("orgPremiumServices",organizationService.getPremiumServices());
		model.addAttribute("orgEmployeeStrength",organizationService.getEmployeeStrength());
	}
	
	@ModelAttribute("sessionWelcomeMessage")
	public String getWelcomeMessage()
	{
		return "Session Form Page";
	}
	@ModelAttribute
	public void getResultMessage(Model model)
	{
		model.addAttribute("sessionResultMessage", "Session Form Result");
	}
	@ModelAttribute("sessionVisitorData")
	public VisitorData getSessionVisitorData()
	{
		return new VisitorData("","",new ArrayList<Visitor>());
	}
	@ModelAttribute("sessionVisitorCount")
	public VisitorCount getSessionVisitorCount()
	{
		return new VisitorCount(0);
	}
}
