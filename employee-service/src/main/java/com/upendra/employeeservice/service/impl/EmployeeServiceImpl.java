package com.upendra.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	
//	private RestTemplate restTemplate;
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {

		Employee employee = employeeRepository.findByEmployeeId(id);
		
//		restTemplate.getForEntity("http://localhost:8083/department/"+employee.getDepartmentCode(),
//				DepartmentDto.class);
		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		return employeeDto;
	}

}
