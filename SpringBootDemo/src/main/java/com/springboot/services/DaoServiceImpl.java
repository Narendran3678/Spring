package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.OrganizationRepository;
import com.springboot.entity.Organization;

@Service
public class DaoServiceImpl implements DaoServices
{
	@Autowired
	OrganizationRepository orgRepo;
	@Override
	public List<Organization> findAll() {
		
		return orgRepo.findAll();
	}

}
