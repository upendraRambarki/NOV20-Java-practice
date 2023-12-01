package com.upendra.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upendra.courses.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Integer>{
	
			public Courses findBycourseId(int id);

			public Courses findByCourseName(String code);
}
