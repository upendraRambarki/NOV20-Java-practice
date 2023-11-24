package com.upendra.intermediate.service;

import java.util.List;

import com.upendra.intermediate.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto getByUserId(Long userId);
	List<UserDto> getAllUsers();
	UserDto updateUser(UserDto user);
	String deleteUser(long id);
	
	
}
