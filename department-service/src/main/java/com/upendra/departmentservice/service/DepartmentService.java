package com.upendra.departmentservice.service;

import java.util.List;

import com.upendra.departmentservice.dto.DepartmentDto;
import com.upendra.departmentservice.entity.Department;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	List<Department> getAllDepartment();
	
	DepartmentDto getDepartmentByCode(String code);
}
