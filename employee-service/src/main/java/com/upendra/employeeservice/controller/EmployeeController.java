package com.upendra.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.employeeservice.dto.ApiResponseDto;
import com.upendra.employeeservice.dto.EmployeeDto;
import com.upendra.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	 @PostMapping("/post")
	    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
	        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }
	 
	 @GetMapping("/get/{id}")
	 public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable Long id)
	 {
		 ApiResponseDto employeeDto = employeeService.getEmployeeById(id);
		 
		 return ResponseEntity.ok(employeeDto);
	 }
}
