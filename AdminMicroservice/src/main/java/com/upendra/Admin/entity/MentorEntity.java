package com.upendra.Admin.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorEntity {
	private Integer mentorId;

	
	private String mentorFirstName;

	
	private String mentorLastName;

	
	private String mentorEmail;

	
	private String mentorPassword;

	
	private String mentorMobileNo;

	
	private int batchSize;

	
	private int currentBatchSize;


	private LocalDate mentorDob;

	
	private LocalDate mentorJoinYear;

	private float avgRating;
}
