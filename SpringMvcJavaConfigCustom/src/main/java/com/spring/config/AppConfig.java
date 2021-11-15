package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.spring.interceptors.HeaderInterceptor;
import com.spring.interceptors.LocationInterceptors;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.spring")
public class AppConfig implements WebMvcConfigurer
{
	@Bean 
	public DataSource dataSource()
	{
		final JndiDataSourceLookup jndiLookup = new JndiDataSourceLookup();
		jndiLookup.setResourceRef(true);
		DataSource dataSource = jndiLookup.getDataSource("jdbc/myoracle");
		return dataSource;
	}
	/*
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping()
	{
		RequestMappingHandlerMapping rmhm= new RequestMappingHandlerMapping();
		rmhm.setUseSuffixPatternMatch(true);
		rmhm.setUseTrailingSlashMatch(true);
		return rmhm;
	}
	*/
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver()
	{
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/").setViewName("index");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HeaderInterceptor());
		registry.addInterceptor(new LocationInterceptors()).addPathPatterns("/locationForm");
	}
	@Bean(name="orgServiceLength")
	PropertiesFactoryBean mapper()
	{
		PropertiesFactoryBean bean=new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("organization-values.properties"));
		return bean;
		
	}
	
}
