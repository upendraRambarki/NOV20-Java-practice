package com.upendra.Admin.service;

import com.upendra.Admin.entity.Admin;
import com.upendra.Admin.entity.AdminResponse;
import com.upendra.Admin.entity.MentorEntity;
import com.upendra.Admin.entity.User;

import java.util.List;


public interface AdminService {

		public List<MentorEntity> getAllMentors();

		//to add admin
		public Admin addAdmin(Admin newAdmin);
		
//		//to get admin by id
//		public Admin getByAdminId(int adminId);
		
		//to get all admins
		public List<Admin> getAllAdmins();
		
		//to delete admin by id
		public String deleteAdminById(int adminId);
		
		//to update admin by id
		public String updateAdmin(int adminId, Admin admin);
		
		
		
		
//		//to get list of all students
//		public List<?> getAllStudents();

		public AdminResponse getByCourseId(Integer id);

		public List<User> getAllUsers();

		
}
