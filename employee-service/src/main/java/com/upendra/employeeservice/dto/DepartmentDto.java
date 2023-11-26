package com.upendra.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	Long id;
    String departmentName;
    String departmentDescription;
    String departmentCode;
}
