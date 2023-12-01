package com.upendra.mentor.service;


import java.util.List;

import com.upendra.mentor.entity.MentorEntity;
import com.upendra.mentor.entity.MentorResponse;

public interface MentorService{
	
	
		public MentorEntity addMentor(MentorEntity newMentor);

		//update mentor
		public MentorEntity updateMentor(int mentorId, MentorEntity newMentor);

		//to get mentor by id
		public MentorEntity getMentorById(int mentorId);

		//to delete mentor
		public String deleteMentorById(int mentorId);	
		
		//get all mentors
		List<MentorEntity> getAllMentors();

		public MentorResponse getByCourseId(Integer id);

	

}
