package com.upendra.student.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.upendra.student.model.Student;

@WebMvcTest(value = StudentService.class)
class StudentServiceTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	StudentService studentService;
	
	
	@Test
	void testGetByName() {
		
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentService.findByName("upendra")).thenReturn(list);
	}
	
	@Test
	void testGetBySalary() {
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentService.findBySalary(246465)).thenReturn(list);
	}
	@Test
	void testGetByAge() {
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentService.findByAge(0)).thenReturn(list);
	}
	

}
