package com.upendra.student.controller;

import java.lang.System.Logger;
import java.security.PublicKey;
import java.util.List;
//import com.upendra.student.controller.logger.GlobalLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.student.model.Student;
import com.upendra.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentCont {
//	private Logger log = GlobalLogger.getLogger(StudentCont.class);
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getByName/{name}")
	public List<Student> getBySytudent(@PathVariable("name") String name) {
		return studentService.findByName(name);
//		logger.trace("getting by name");
	}
	@GetMapping("/getByAge/{age}")
	public List<Student> getByAge(@PathVariable("age") int age) {
		return studentService.findByAge(age);
		
	}
	
	@GetMapping("/getBySalary/{salary}")
	public List<Student> getBySalary(@PathVariable("salary") long salary) {
		return studentService.findBySalary(salary);
		
	}
	
	@PostMapping("/post")
	public Student post(@RequestBody Student student)
	{
		return studentService.post(student);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student)
	{
		return studentService.updateStudent(student);
		
	}
	@DeleteMapping("/delete")
	public String removeStudent(String name)
	{
		return studentService.deleteStudent(name);
		
	}
}
