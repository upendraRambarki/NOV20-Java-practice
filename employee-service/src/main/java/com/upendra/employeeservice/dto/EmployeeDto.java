package com.upendra.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
//    private String departmentCode;
    
}
