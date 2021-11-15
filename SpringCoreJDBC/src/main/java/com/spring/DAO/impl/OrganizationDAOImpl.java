package com.spring.DAO.impl;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.DAO.OrganizationDAO;
import com.spring.Entity.Organization;
@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
	
	public OrganizationDAOImpl()
	{
		
	}
	JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) 
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Organization> getAllOrganization() {
		String query="SELECT * FROM ORGANIZATION ";		
		List<Organization> organizationList= jdbcTemplate.query(query, new OrganizationRowMapper());
		return organizationList;
	}

	public List<Organization> getOrganization(int id) 
	{
		String query= " select * from organization where id=? ";
		Object args[]= new Object[] {id};
		List<Organization> organizationList = jdbcTemplate.query(query,new OrganizationRowMapper(), args); 
		return organizationList;
	}

	public boolean createOrganization(Organization organization) 
	{
		String insertQuery=" insert into organization(company_name,years_of_incorporation,postal_code,employee_count,slogan) "
						 + " values( ?,?,?,?,?) ";
		Object args[]= new Object[] {organization.getCompanyName(),organization.getYearOfIncorporation(),organization.getPostalCode(),organization.getEmployeeCount(),organization.getSlogan()};
		return jdbcTemplate.update(insertQuery,args)==1;
	}

	public boolean updateOrganization(Organization organization) {
	
		String query= " update organization set slogan=? where id=? ";
		Object args[]= new Object[] {organization.getSlogan(),organization.getId()};
		return jdbcTemplate.update(query,args)==1;
	}

	public boolean deleteOrganization(Organization organization) {
		String query= " delete from organization where id=? ";
		Object args[]= new Object[] {organization.getId()};
		return jdbcTemplate.update(query,args)==1;
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

}
