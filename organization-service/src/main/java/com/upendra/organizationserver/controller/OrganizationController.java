package com.upendra.organizationserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.organizationserver.dto.OrganizationDto;
import com.upendra.organizationserver.service.OrganizationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/organization")
@AllArgsConstructor
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;
	
	@PostMapping("/post")
	public OrganizationDto createOrganization(@RequestBody OrganizationDto organizationDto)
	{
		OrganizationDto organizationDto2 = organizationService.saveOrganization(organizationDto);
		
		return organizationDto2;
	}
	
	@GetMapping("/get/{code}")
	public OrganizationDto getByOrganizationCode(@PathVariable("code") String organizationCode)
	{
		OrganizationDto organizationDto = organizationService.getByOrganizationByCode(organizationCode);
		 return  organizationDto;
	}
}
