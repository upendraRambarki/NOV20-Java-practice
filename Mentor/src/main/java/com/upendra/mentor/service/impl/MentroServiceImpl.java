package com.upendra.mentor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.upendra.mentor.Exception.ResourceNotFoundException;
import com.upendra.mentor.entity.Courses;
import com.upendra.mentor.entity.MentorEntity;
import com.upendra.mentor.entity.MentorResponse;
import com.upendra.mentor.repository.MentorRepository;
import com.upendra.mentor.service.MentorService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class MentroServiceImpl implements MentorService{

	@Autowired
	MentorRepository mentorRepository;
	WebClient webClient;
	
		@Override
		public List<MentorEntity> getAllMentors() 
		{
			return mentorRepository.findAll();
		}

	@Override
	public MentorEntity updateMentor(int mentorId, MentorEntity newMentor) 
	
	{
		MentorEntity mentor = mentorRepository.findById(mentorId)
				.orElseThrow(() -> new ResourceNotFoundException("Mentor Does Not Exist"));

		mentor.setMentorFirstName(newMentor.getMentorFirstName());
		mentor.setMentorLastName(newMentor.getMentorLastName());
		mentor.setMentorEmail(newMentor.getMentorEmail());
		mentor.setMentorPassword(newMentor.getMentorPassword());
		mentor.setMentorMobileNo(newMentor.getMentorMobileNo());
		mentor.setMentorDob(newMentor.getMentorDob());
		mentor.setMentorJoinYear(newMentor.getMentorJoinYear());
		mentor.setAvgRating(newMentor.getAvgRating());	
		mentorRepository.save(mentor);
		return mentor;
	}

	@Override
	public MentorEntity getMentorById(int mentorId) {
		MentorEntity mentor = mentorRepository.findById(mentorId)
				.orElseThrow(() -> new ResourceNotFoundException("No such mentor exist"));
		return mentor;
	}

	@Override
	public String deleteMentorById(int mentorId) {
		MentorEntity admin = mentorRepository.findById(mentorId)
				.orElseThrow(() -> new ResourceNotFoundException("No mentor Found!"));
		mentorRepository.delete(admin);
		return "Mentor with Id: " + mentorId + " deleted!";
	}

	

	@Override
	public MentorEntity addMentor(MentorEntity newMentor) {
		MentorEntity mentor = mentorRepository.findByMentorEmail(newMentor.getMentorEmail());
		if(mentor == null) 
		{
			newMentor.MentorStatus();
			return mentorRepository.save(newMentor);
		}
		else
		{
			throw new ResourceNotFoundException("Admin already exists with email id : " + newMentor.getMentorEmail());
		}
	}

	@Override
	public MentorResponse getByCourseId(Integer id) {
		MentorEntity mentor = mentorRepository.findByMentorId(id);
		
		Courses course =webClient.get()
				  .uri("http://localhost:9005/courses/getByCourse/"+
                  mentor.getCourseName()) 
				  .retrieve() 
				  .bodyToMono(Courses.class)
				  .block();
		
		

		MentorResponse mentorResponse = new MentorResponse();
		mentorResponse.setCourses(course);
		mentorResponse.setMentorEntity(mentor);
		
		
		return mentorResponse;
	}
	
	

}
