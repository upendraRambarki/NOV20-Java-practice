package com.upendra.mentor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.mentor.entity.MentorEntity;
import com.upendra.mentor.entity.MentorResponse;
import com.upendra.mentor.service.MentorService;

@RestController
@RequestMapping("/mentor")
public class MentorController 
{
	@Autowired
	MentorService mentorService;
	
	@PostMapping("/add")
	public ResponseEntity<MentorEntity> newMentor(@RequestBody MentorEntity newAdmin){
		return ResponseEntity.ok(mentorService.addMentor(newAdmin));
	}
	@GetMapping("/get/{id}")
	 public ResponseEntity<MentorResponse> getByCourseName(@PathVariable Integer id)
	 {
		MentorResponse mentorResponse = mentorService.getByCourseId(id);
		 
		 return ResponseEntity.ok(mentorResponse);
	 }
	
	@GetMapping("/getAll")
	public ResponseEntity<List<MentorEntity>> getAllMentors(){
		return ResponseEntity.ok(mentorService.getAllMentors());
	}
	
	@PutMapping("/{mentorId}")
	public ResponseEntity<MentorEntity> updateMentor(@PathVariable int mentorId, @RequestBody MentorEntity newMentor){
		return ResponseEntity.ok(mentorService.updateMentor(mentorId, newMentor));
	}
	

	@GetMapping("/{mentorId}")
	public ResponseEntity<MentorEntity> getMentorById(@PathVariable int mentorId)
	{
		return ResponseEntity.ok(mentorService.getMentorById(mentorId));
	}
		
	@DeleteMapping("/{mentorId}")   
	public ResponseEntity<?> deleteMentorById(@PathVariable int mentorId)
	{
		return ResponseEntity.ok(mentorService.deleteMentorById(mentorId));
	}
	
}
