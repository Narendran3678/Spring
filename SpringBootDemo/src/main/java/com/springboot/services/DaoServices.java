package com.springboot.services;

import java.util.List;

import com.springboot.entity.Organization;

public interface DaoServices {
	public List<Organization> findAll();
}
