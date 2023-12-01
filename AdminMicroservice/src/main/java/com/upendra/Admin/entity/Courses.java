package com.upendra.Admin.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses 
{
	private int courseId;
	
	
	private String courseName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String discription;
}
