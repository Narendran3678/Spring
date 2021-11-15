package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

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

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver()
	{
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
}
