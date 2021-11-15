package com.spring.interceptors;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@SuppressWarnings("deprecation")
public class HeaderInterceptor extends HandlerInterceptorAdapter 
{
	private static Logger LOGGER = LoggerFactory.getLogger(LocationInterceptors.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		request.setAttribute("headerMessage", "Welcome to Spring MVC Course");
		request.setAttribute("requestAttributeVal", "Request Attribute Value");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("currentTime")==null)
		{
			session.setAttribute("currentTime",LocalDateTime.now());
		}
		String locationName = request.getParameter("locationName");
		LOGGER.info("Location Name-"+locationName);
		if(locationName != null) {
			request.setAttribute("locationName", locationName);
		}
		return true;
	}
}
