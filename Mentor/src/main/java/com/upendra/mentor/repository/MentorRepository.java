package com.upendra.mentor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upendra.mentor.entity.MentorEntity;

@Repository
public interface MentorRepository extends JpaRepository<MentorEntity, Integer>
{
		

		//to find mentor by email & password (to authenticate mentor)
		public MentorEntity findByMentorEmailAndMentorPassword(String email, String password);

		//to find mentor by email 
		public MentorEntity findByMentorEmail(String mentorEmail);

		public MentorEntity findByMentorId(Integer id);
}
