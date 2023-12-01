package com.upendra.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upendra.Admin.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByAdminEmailAndAdminPassword(String email,String password);
	
	Admin findByAdminEmail(String email);

	Admin findByAdminId(Integer id);
}
