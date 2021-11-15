package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.spring.service.ServiceInterface;

@Controller
public class HomeController 
{
	@Autowired
	ServiceInterface serviceInterface;
	@RequestMapping("/")
	public String indexPage(Model model)
	{
		List<String> message = serviceInterface.getMessage("Naren");
		model.addAttribute("message", message);
		return "index";
	}
}
