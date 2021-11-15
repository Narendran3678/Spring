package com.spring.Core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.DAO.DAOUtils;
import com.spring.DAO.OrganizationDAO;
import com.spring.DAO.impl.OrganizationDAOImpl;
import com.spring.Entity.Organization;
public class MainApplication 
{
	public static Logger logger=LoggerFactory.getLogger("MainApplication");
	public static void main(String args[])
	{
		logger.info("Bean Factory Method");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		OrganizationDAO organizationDAO =  (OrganizationDAO) context.getBean("organizationDAO");
		//organizationDAO.getAllOrganization();
		//DAOUtils.createSeedData(organizationDAO);
		DAOUtils.printOrganizations(organizationDAO.getAllOrganization(), "READ");
		//Logger.info(organizationDAO.getOrganization(71));
		
		//Update
		/*
		Organization org=new Organization(); org.setId(81); org.setSlogan("Test");
		organizationDAO.updateOrganization(org);
		Logger.info(organizationDAO.getOrganization(org.getId()));
		*/
		
		//Delete
		//Organization org=new Organization(); org.setId(81);
		//organizationDAO.deleteOrganization(org);
		//logger.info(organizationDAO.getOrganization(75));
		((ClassPathXmlApplicationContext)context).close();
	}
}

