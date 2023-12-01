package com.upendra.mentor.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
	public int courseId;
	
	
	public String courseName;
	
	public LocalDate startDate;
	
	public LocalDate endDate;
	
	public String discription;
}
