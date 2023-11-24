package com.upendra.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upendra.departmentservice.dto.DepartmentDto;
import com.upendra.departmentservice.entity.Department;
import com.upendra.departmentservice.mapper.DepartmentMapper;
import com.upendra.departmentservice.repository.DepartmentRepository;
import com.upendra.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	 DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		 // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		Department department = departmentRepository.findByDepartmentCode(code);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
	}

    
}
