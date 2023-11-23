package com.upendra.intermediate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upendra.intermediate.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserId(Long id);

}
