package com.upendra.employeeservice.service;

import com.upendra.employeeservice.dto.EmployeeDto;

public interface EmployeeService 
{
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
