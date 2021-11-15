package com.spring.doa.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.entity.Organization;
public class OrganizationRowMapper implements RowMapper<Organization> {

	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
		Organization organization=new Organization();
		organization.setCompanyName(rs.getString("company_name"));
		organization.setEmployeeCount(rs.getInt("employee_count"));
		organization.setId(rs.getInt("id"));
		organization.setSlogan(rs.getString("slogan"));
		organization.setYearOfIncorporation(rs.getInt("years_of_incorporation"));
		organization.setPostalCode(rs.getString("postal_code"));
		return organization;
	}

}
