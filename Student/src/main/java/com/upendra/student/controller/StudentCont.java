package com.upendra.student.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.student.model.Student;
import com.upendra.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentCont {

	Logger logger = LoggerFactory.getLogger(StudentCont.class);
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getByName/{name}")
	public List<Student> getBySytudent(@PathVariable("name") String name) {
		
		logger.trace("getting student details by name excecuted sucessfully");
//		 logger.error("An ERROR Message");
		return studentService.findByName(name);
		
	}
	@GetMapping("/getByAge/{age}")
	public List<Student> getByAge(@PathVariable("age") int age) {
		logger.trace("getting students details by age excecuted sucessfully");

		return studentService.findByAge(age);
		
	}
	
	@GetMapping("/getBySalary/{salary}")
	public List<Student> getBySalary(@PathVariable("salary") long salary) {
		logger.trace("getting student detaisl by salary excecuted sucessfully");

		return studentService.findBySalary(salary);
		
	}
	
	@PostMapping("/post")
	public Student post(@RequestBody Student student)
	{
		logger.trace("added student details excecuted sucessfully");

		return studentService.post(student);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student)
	{
		logger.trace("updated student details excecuted sucessfully");

		
		return studentService.updateStudent(student);
		
	}
	@DeleteMapping("/delete")
	public String removeStudent(String name)
	{
		logger.trace("deleted student details excecuted sucessfully");

		return studentService.deleteStudent(name);
		
	}
}
