package com.upendra.courses.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="course")
public class Courses {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int courseId;
	@Column(name="course_name")
	
	public String courseName;
	@Column(name="start_date")
	public LocalDate startDate;
	@Column (name="end_date")
	public LocalDate endDate;
	@Column(name="description")
	public String discription;

}
