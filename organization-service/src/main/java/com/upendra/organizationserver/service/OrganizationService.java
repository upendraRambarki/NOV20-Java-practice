package com.upendra.organizationserver.service;

import com.upendra.organizationserver.dto.OrganizationDto;

public interface OrganizationService {

	
	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	
	OrganizationDto getByOrganizationByCode(String organizationCode);
}
