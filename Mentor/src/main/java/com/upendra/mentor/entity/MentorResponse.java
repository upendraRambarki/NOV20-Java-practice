package com.upendra.mentor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class MentorResponse {

	private Courses courses;
	private MentorEntity mentorEntity;
}
