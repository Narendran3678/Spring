package com.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext annotationContext=new AnnotationConfigWebApplicationContext();
		annotationContext.register(AppConfig.class);
		
		ServletRegistration.Dynamic registration =  servletContext.addServlet("dispatcher", new DispatcherServlet(annotationContext));
		registration.addMapping("/");
		registration.setLoadOnStartup(1);
	}
}
