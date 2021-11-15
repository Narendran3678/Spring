package com.spring.DAO;
import java.util.List;

import javax.sql.DataSource;
import com.spring.Entity.Organization;
public interface OrganizationDAO 
{
	public void setDataSource(DataSource dataSource);
	public List<Organization> getAllOrganization();
	public List<Organization> getOrganization(int id);
	public boolean createOrganization(Organization organization);
	public boolean updateOrganization(Organization organization);
	public boolean deleteOrganization(Organization organization);
	public void cleanUp();
}
