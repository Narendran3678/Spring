package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long>{

}
