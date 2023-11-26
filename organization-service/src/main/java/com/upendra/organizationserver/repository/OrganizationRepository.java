package com.upendra.organizationserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upendra.organizationserver.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,Long>{

	
	Organization findByOrganizationCode(String organizationCode);
}
