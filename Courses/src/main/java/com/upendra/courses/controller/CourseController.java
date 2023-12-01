
package com.upendra.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.courses.entity.Courses;
import com.upendra.courses.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/getAllCourses")
	public List<Courses> getAllCourses(){
		return courseService.getAll();	}
	
	@GetMapping("getByCourse/{course}")
	public Courses getByCourse(@PathVariable("course") String course)
	{
		Courses courses = courseService.getByCourseName(course);
		return courses;
	}
	@PostMapping("/addCourses")
	public Courses addCourses(@RequestBody Courses courses) {
		return courseService.addCourses(courses);
	}
	@PutMapping("/updateCourses")
	public Courses updateCourses(@RequestBody Courses courses) {
		return courseService.updateCourse(courses);
	}
	@DeleteMapping("/removeCourse")
	public String removeCourse(@PathVariable("id") int id) {
		return courseService.deleteCourse(id);
	}

}
