package com.upendra.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.upendra.student.model.Student;
import com.upendra.student.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	public List<Student> findByName(String name) {
		return repo.findByName(name);
	}
	
	public List<Student> findByAge(int age) {
		return repo.findByAge(age);
	}
	public List<Student> findBySalary(long salary) {
		return repo.findBySalary(salary);
	}
	public Student post(Student student)
	{
		return repo.save(student);
	}
}
