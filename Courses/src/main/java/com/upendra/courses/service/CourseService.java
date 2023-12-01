package com.upendra.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upendra.courses.entity.Courses;
import com.upendra.courses.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Courses> getAll(){
		return courseRepository.findAll();
		}
  public Courses addCourses(Courses courses) {
	  return courseRepository.save(courses);
  }
  
  public Courses updateCourse(Courses courses) {
	  
	  Courses courses2=courseRepository.findBycourseId(courses.getCourseId());
	  courses2.setCourseName(courses.getCourseName());
	  courses2.setStartDate(courses.getStartDate());
	  courses2.setEndDate(courses.getEndDate());
	  courses2.setDiscription(courses.getDiscription());
	  
	  return courseRepository.save(courses2);	    	  
  }
  
  public String deleteCourse(int id) {
	  Courses courses=courseRepository.findBycourseId(id);
	  courseRepository.delete(courses);
	  return "course deleted";
  }
public Courses getByCourseName(String code) {
	Courses courses = courseRepository.findByCourseName(code);
		
	return courses;
  
  
}
}
