package com.spring.DAO.impl;
import java.util.*;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.spring.DAO.OrganizationDAO;
import com.spring.Entity.Organization;
@Repository
public class OrganizationDAOImplNamedTemplate implements OrganizationDAO {
	
	public OrganizationDAOImplNamedTemplate()
	{
		
	}
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public void setDataSource(DataSource dataSource) 
	{
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Organization> getAllOrganization() {
		try
		{
			String query="SELECT * FROM ORGANIZATION ";		
			List<Organization> organizationList= namedParameterJdbcTemplate.query(query, new OrganizationRowMapper());
			return organizationList;
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}

	public List<Organization> getOrganization(int id) 
	{	
		try
		{
			List<Organization> organizationList =new ArrayList<Organization>();
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("ID",id);
			SqlParameterSource param = new MapSqlParameterSource(map);
			String query= " select * from organization where id=:ID ";
			Organization organization = namedParameterJdbcTemplate.queryForObject(query, param, new OrganizationRowMapper()) ;
			if(organization!=null)
				organizationList.add(organization);
			return organizationList;
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}

	public boolean createOrganization(Organization organization) 
	{
		SqlParameterSource param =  new BeanPropertySqlParameterSource(organization);
		String insertQuery=" insert into organization(company_name,years_of_incorporation,postal_code,employee_count,slogan) "
						 + " values( :companyName,:yearOfIncorporation,:postalCode,:employeeCount,:slogan) ";
		
		return namedParameterJdbcTemplate.update(insertQuery,param)==1;
	}

	public boolean updateOrganization(Organization organization) 
	{	
		SqlParameterSource param = new BeanPropertySqlParameterSource(organization);
		String query= " update organization set slogan=:slogan where id=:id ";
		return namedParameterJdbcTemplate.update(query,param)==1;
	}

	public boolean deleteOrganization(Organization organization) 
	{
		SqlParameterSource param = new BeanPropertySqlParameterSource(organization);
		
		String query= " delete from organization where id=:id ";
		return namedParameterJdbcTemplate.update(query,param)==1;
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

}
