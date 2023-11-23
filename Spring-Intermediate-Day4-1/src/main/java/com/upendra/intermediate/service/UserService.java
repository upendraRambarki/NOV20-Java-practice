package com.upendra.intermediate.service;

import java.util.List;

import com.upendra.intermediate.entity.User;

public interface UserService {
	User createUser(User user);
	User getByUserId(Long userId);
	List<User> getAllUsers();
	User updateUser(User user);
	String deleteUser(long id);
	
	
}
