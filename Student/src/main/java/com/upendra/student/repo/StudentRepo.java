package com.upendra.student.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.upendra.student.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>{

	List<Student> findByName(String name);
	List<Student> findBySalary(long salary);
	List<Student> findByAge(int age);
}
