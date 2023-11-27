package com.upendra.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.upendra.employeeservice.dto.DepartmentDto;



@FeignClient(url = "http://localhost:8085",value="department")
public interface ApiClient {
	
	
	@GetMapping("department/getByCode/{code}")
	DepartmentDto getByCode(@PathVariable("code") String code);
	
//	@GetMapping("/get/{code}")
//	OrganizationDto getByOrganizationCode(@PathVariable("code") String organizationCode);
	

}
