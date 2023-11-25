package com.upendra.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.departmentservice.dto.DepartmentDto;
import com.upendra.departmentservice.entity.Department;
import com.upendra.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/post")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
	{
		DepartmentDto department = departmentService.saveDepartment(departmentDto);
		return ResponseEntity.ok(department);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Department>> getDepartment()
	{
		List<Department> department =	 departmentService.getAllDepartment();
		return ResponseEntity.ok(department);
	}
	
	@GetMapping("getByCode/{code}")
	public DepartmentDto getByCode(@PathVariable("code") String code)
	{
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
		return departmentDto;
	}
}
