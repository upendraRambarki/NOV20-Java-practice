package com.upendra.Admin.controller;

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

import com.upendra.Admin.entity.Admin;
import com.upendra.Admin.entity.AdminResponse;
import com.upendra.Admin.entity.MentorEntity;
import com.upendra.Admin.service.AdminService;
import com.upendra.Admin.entity.User;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
		@PostMapping("/add")
		public ResponseEntity<Admin> addAdmin(@RequestBody Admin newAdmin){
			return ResponseEntity.ok(adminService.addAdmin(newAdmin));
		}
	//to get admin id
//		@GetMapping("get/{id}")
//		public ResponseEntity<Admin> getDetailsById(@PathVariable int id){
//			return ResponseEntity.ok(adminService.getByAdminId(id));
//		}
		
		
		//to get all list of all admins
		@GetMapping("/get")
		public ResponseEntity<List<Admin>> getAllAdmins(){
			return ResponseEntity.ok(adminService.getAllAdmins());
		}
		
		@GetMapping("/getAllMentors")
		public List<MentorEntity> getAllMentors()
		{
			return adminService.getAllMentors();
		}
		@GetMapping("/getAllUser")
		public ResponseEntity<List<User>> getAllUsers()
		{
			List<User> user = adminService.getAllUsers();
			return ResponseEntity.ok(user);
		}
		
		//to delete admin by id
		@DeleteMapping("delete/{adminId}")
		public ResponseEntity<String> deleteAdminById(@PathVariable int adminId){
			return ResponseEntity.ok(adminService.deleteAdminById(adminId));
		}
		
		
		//to update admin
		@PutMapping("update/{adminId}")
		public ResponseEntity<String> updateAdmin(@PathVariable int adminId, @RequestBody Admin admin){
			return ResponseEntity.ok(adminService.updateAdmin(adminId, admin));
		}
		@GetMapping("/get/{id}")
		 public ResponseEntity<AdminResponse> getByCourseName(@PathVariable Integer id)
		 {
			AdminResponse mentorResponse = adminService.getByCourseId(id);
			 
			 return ResponseEntity.ok(mentorResponse);
		 }
}
