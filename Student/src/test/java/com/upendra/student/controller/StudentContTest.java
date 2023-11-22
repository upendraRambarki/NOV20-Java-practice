package com.upendra.student.controller;

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
import com.upendra.student.service.StudentService;

@WebMvcTest(value = StudentCont.class)
class StudentContTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	StudentCont studentCont;
	
	@MockBean
	StudentService studentService;
	
	
	@Test
	void testGetBySytudent() {
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentCont.getBySytudent("upendra")).thenReturn(list);
		assertEquals(list, studentCont.getBySytudent("upendra"));
	}
	
	@Test
	void testGetBySalary() {
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentCont.getBySalary(40000000)).thenReturn(list);
		
		assertEquals(list, studentCont.getBySalary(40000000));
	}
	@Test
	void testGetByAge() {
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentCont.getByAge(44)).thenReturn(list);
		assertEquals(list, studentCont.getByAge(44));
	}
	
	@Test
	void testPost()
	{
		Student student = new Student();
		when(studentCont.post(student)).thenReturn(student);
		
	}
	
	@Test
	void testUpdateStudent()
	{
		Student student = new Student("Upendra", 44, 40000000);
		when(studentCont.updateStudent(student)).thenReturn(student);
		assertEquals(student, studentCont.updateStudent(student));
	}
	@Test
	void testRemoveStudent()
	{
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentCont.removeStudent("upendra")).then(null);	
		assertEquals(list, studentCont.getBySytudent("upendra"));
	}
	
	

}
