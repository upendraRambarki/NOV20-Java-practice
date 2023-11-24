package com.upendra.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upendra.departmentservice.entity.Department;

public interface DepartmentRepository extends  JpaRepository<Department, Long> {

	Department findByDepartmentCode(String code);


}
