package com.spring.DAO;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.Entity.Organization;
public class DAOUtils {
	public static Logger logger=LoggerFactory.getLogger("DAOUtils");
	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";

	public static void printOrganizations(List<Organization> orgs, String operation){
	    logger.info("\n********* printing organizations after " + operation + " operation *********");
	    for (Organization org : orgs) {
	        logger.info(org.toString());
	    }
	}

	public static void printSuccessFailure(String operation, boolean param){
	    if(param)
	        logger.info("\nOperation " + operation + " successful");
	    else
	        logger.info("\nOperation " + operation + " failed");
	}
	
	public static void createSeedData(OrganizationDAO dao){
	    Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
	    Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");;
	    Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");
	     
	    List<Organization> orgs = new ArrayList<Organization>();
	    orgs.add(0, org1); orgs.add(1, org2); orgs.add(2, org3);
	   
	    int createCount = 0;
	    for(Organization org : orgs)
	    {
	    	boolean isCreated  = dao.createOrganization(org);
	        if(isCreated)
	            createCount += 1;
	    }
	             
	    logger.info("Created "+ createCount + " organizations");
	}
	
	public static void printOrganizationCount(List<Organization> orgs, String operation){
	    logger.info("\n*********Currently we have " + orgs.size()+ " organizations after " + operation + " operation" + "   *********");
	     
	}
}
