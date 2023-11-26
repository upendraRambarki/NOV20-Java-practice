package com.upendra.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.upendra.employeeservice.dto.ApiResponseDto;
import com.upendra.employeeservice.dto.DepartmentDto;
import com.upendra.employeeservice.dto.EmployeeDto;
import com.upendra.employeeservice.entity.Employee;
import com.upendra.employeeservice.mapper.EmployeeMapper;
import com.upendra.employeeservice.repository.EmployeeRepository;
import com.upendra.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	RestTemplate restTemplate;
	
	
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
		
		ResponseEntity<DepartmentDto> response =restTemplate.getForEntity("http://localhost:8085/department/getByCode/"+employee.getDepartmentCode(), DepartmentDto.class);
		
		DepartmentDto departmentDto = response.getBody();
		

		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		
		
		return apiResponseDto;
	}

}
