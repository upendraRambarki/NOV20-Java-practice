package com.upendra.mentor.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mentor")
public class MentorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mentorId;

	@Column(name="mentor_fname")
	private String mentorFirstName;

	@Column(name="mentor_lname")
	private String mentorLastName;

	@Column(name="mentor_email")
	private String mentorEmail;

	@Column(name="mentor_password")
	private String mentorPassword;

	@Column(name="mentor_mono")
	private String mentorMobileNo;

	@Column(name="batch_size")
	private int batchSize;

	@Column(name = "current_batch_size", columnDefinition = "integer default 00")
	private int currentBatchSize;

	@Column(name="mentor_dob")
	private LocalDate mentorDob;

	@Column(name="mentor_join_year")
	private LocalDate mentorJoinYear;

	@Column(name="avg_rating")
	private float avgRating;

	private String courseName;
	
	private String status;
	
	public void MentorStatus() {
		
		this.status = (courseName==null || courseName.isEmpty())?"free":"occupied";
		System.out.println(status);
	}
//	Address mentorAddress;

//	private Course assignedMentorCourseId;
}
