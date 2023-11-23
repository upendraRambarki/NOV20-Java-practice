package com.upendra.student.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.upendra.student.model.Student;
import com.upendra.student.repo.StudentRepo;

@WebMvcTest(value = StudentService.class)
class StudentServiceTest {
	
	@Autowired
	MockMvc mockMvc;
	
@Autowired	StudentService studentService;
	
	@MockBean
	StudentRepo studentRepo;
	
	
	
	@Test
	void testGetByName() {
		
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentService.findByName("upendra")).thenReturn(list);
		assertEquals(list, studentService.findByName("upendra"));
	}
	
	@Test
	void testFindBySalary() {
		List<Student> list1 = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list1.add(student);
		Mockito.when(studentRepo.findBySalary(40000000)).thenReturn(list1);
		assertEquals(list1, studentService.findBySalary(40000000));

	}
	@Test
	void testGetByAge() {
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		when(studentService.findByAge(44)).thenReturn(list);
		assertEquals(list, studentService.findByAge(44));
	}
	@Test
	void testUpdateStudent()
	{
		Student student = new Student("Upendra", 44, 40000000);
		when(studentService.updateStudent(student)).thenReturn(student);
		assertEquals(student, studentService.updateStudent(student));

	}
	@Test
	void testPost()
	{
		Student student = new Student("Upendra", 44, 40000000);
		when(studentService.updateStudent(student)).thenReturn(student);
		assertEquals(student, studentService.post(student));
	}
	@Test
	void testRemoveStudent()
	{
		List<Student> list = new ArrayList<>();

		Student student = new Student("Upendra", 44, 40000000);
		list.add(student);
		Mockito.when(studentService.deleteStudent("upendra")).thenReturn("Deleted");	
		assertEquals("Deleted", studentService.deleteStudent("upendra"));
	}

}
