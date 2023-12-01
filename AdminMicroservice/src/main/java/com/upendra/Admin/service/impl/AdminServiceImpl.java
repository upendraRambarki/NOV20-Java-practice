package com.upendra.Admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.upendra.Admin.entity.Admin;
import com.upendra.Admin.entity.AdminResponse;
import com.upendra.Admin.entity.Courses;
import com.upendra.Admin.exception.ResourceNotFoundException;
import com.upendra.Admin.repository.AdminRepository;
import com.upendra.Admin.service.AdminService;
import com.upendra.Admin.entity.MentorEntity;
import com.upendra.Admin.entity.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	RestTemplate restTemplate;
	WebClient webClient;
	
	@Override
	public Admin addAdmin(Admin newAdmin) {
		Admin admin = adminRepository.findByAdminEmail(newAdmin.getAdminEmail());
		if(admin == null) 
		{
			return adminRepository.save(newAdmin);
		}
		else
		{
			throw new ResourceNotFoundException("Admin already exists with email id : " + newAdmin.getAdminEmail());
		}
	}

//	@Override
//	public Admin getByAdminId(int adminId) {
//		return adminRepository.findById(adminId)
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid Admin ID!") );
//		
//	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public String deleteAdminById(int adminId) {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("No Admin Found!"));
		adminRepository.delete(admin);
		return "Admin with Id: " + adminId + " deleted!";
	}

	@Override
	public String updateAdmin(int adminId, Admin admin) {
				//get existingAdmin from by adminId
				Admin existingAdmin = adminRepository.findById(adminId)
						.orElseThrow(() -> new ResourceNotFoundException("No Admin Found!"));
				
				//set admin's fields to the existingAdmin
				existingAdmin.setAdminEmail(admin.getAdminEmail());
				existingAdmin.setAdminPassword(admin.getAdminPassword());
				existingAdmin.setAdminDob(admin.getAdminDob());
//				existingAdmin.setAdminGender(admin.getAdminGender());
				
				//save admin in DB
				adminRepository.save(existingAdmin);
				return "Admin with Id: " + adminId + " updated!";
	}



//	@Override
//	public List<?> getAllStudents() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public AdminResponse getByCourseId(Integer id) {
		
		Admin admin = adminRepository.findByAdminId(id);
		
		Courses course =webClient.get()
				  .uri("http://localhost:9005/courses/getByCourse/"+
                  admin.getCourseName()) 
				  .retrieve() 
				  .bodyToMono(Courses.class)
				  .block();
		
		

		AdminResponse adminResponse = new AdminResponse();
		adminResponse.setAdmin(admin);
		adminResponse.setCourses(course);
		
		
		
		return adminResponse;
	}
	@Override
	public List<MentorEntity> getAllMentors() 
	{
		
		ResponseEntity<List<MentorEntity>> response = restTemplate.exchange("http://localhost:9006/mentor/getAll",
				HttpMethod.GET,null, new ParameterizedTypeReference<List<MentorEntity>>(){});
		List<MentorEntity> mentorEntity = response.getBody();
		 
		 
//		MentorEntity mentor =webClient.get()
//							.uri("http://localhost:9006/mentor/getAll") 
//				  .retrieve() 
//				  .bodyToMono(MentorEntity.class)
//				  .block();
		return mentorEntity;
	}

	@Override
	public List<User> getAllUsers() {
		ResponseEntity<List<User>> response = restTemplate.exchange("http://localhost:8082/user/getAll",
				HttpMethod.GET,null, new ParameterizedTypeReference<List<User>>(){});
		List<User> user = response.getBody();
		return user;
	}
	

}
