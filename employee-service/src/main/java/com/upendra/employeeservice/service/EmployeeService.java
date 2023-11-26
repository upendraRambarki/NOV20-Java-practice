package com.upendra.employeeservice.service;

import com.upendra.employeeservice.dto.ApiResponseDto;
import com.upendra.employeeservice.dto.EmployeeDto;

public interface EmployeeService 
{
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
