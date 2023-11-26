package com.upendra.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long employeeId;
	    private String firstName;
	    private String lastName;
	    @Column(nullable = false, unique = true)
	    private String email;
	    private String departmentCode;
	    
}
