 package com.springboot;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootApp 
{
	public static void main(String args[])
	{
		SpringApplication.run(SpringBootApp.class, args);
	}
	
	@Bean
	public LocaleResolver getLocaleResolver()
	{
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
	}	
	
	@Bean
	public ResourceBundleMessageSource getResourceBundleMessageSource()
	{
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}
}
