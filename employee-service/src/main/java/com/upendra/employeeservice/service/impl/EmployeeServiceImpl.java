package com.upendra.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.upendra.employeeservice.dto.ApiResponseDto;
import com.upendra.employeeservice.dto.DepartmentDto;
import com.upendra.employeeservice.dto.EmployeeDto;
import com.upendra.employeeservice.dto.OrganizationDto;
import com.upendra.employeeservice.entity.Employee;
import com.upendra.employeeservice.mapper.EmployeeMapper;
import com.upendra.employeeservice.repository.EmployeeRepository;
import com.upendra.employeeservice.service.ApiClient;
import com.upendra.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

//	RestTemplate restTemplate;
	
	WebClient webClient;
	
	ApiClient apiClient;
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
	}

	@Override
	public ApiResponseDto getEmployeeById(Long id) {

		Employee employee = employeeRepository.findByEmployeeId(id);
		
		//it is used by using restTemplate concept
		/*
		 * ResponseEntity<DepartmentDto> response
		 * =restTemplate.getForEntity("http://localhost:8085/department/getByCode/"+
		 * employee.getDepartmentCode(), DepartmentDto.class);
		 * 
		 * DepartmentDto departmentDto = response.getBody();
		 */
		
		//the below method used to communicate from department using webclient
		/*
		 * DepartmentDto departmentDto =webClient.get()
		 * .uri("http://localhost:8085/department/getByCode/"+
		 * employee.getDepartmentCode()) .retrieve() .bodyToMono(DepartmentDto.class)
		 * .block();
		 */
		OrganizationDto organizationDto =webClient.get()
				  							  .uri("http://localhost:8086/organization/get/"+
						                        employee.getOrganizationCode()) 
				  							  .retrieve() 
				  							  .bodyToMono(OrganizationDto.class)
				  							  .block();
		
		DepartmentDto  departmentDto = apiClient.getByCode(employee.getDepartmentCode());
		

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setOrganizationDto(organizationDto);
		
		return apiResponseDto;
	}

}
