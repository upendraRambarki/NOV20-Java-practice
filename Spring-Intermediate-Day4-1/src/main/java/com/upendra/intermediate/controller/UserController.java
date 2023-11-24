package com.upendra.intermediate.controller;

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

import com.upendra.intermediate.dto.UserDto;
import com.upendra.intermediate.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/post")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user)
	{
		UserDto user2 = userService.createUser(user);
		return ResponseEntity.ok(user2);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable Long id)
	{
		UserDto user = userService.getByUserId(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		List<UserDto> user = userService.getAllUsers();
		return ResponseEntity.ok(user);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto userDto)
	{
		userDto.setUserId(id);
		return ResponseEntity.ok(userService.updateUser(userDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id)
	{
		
		return ResponseEntity.ok(userService.deleteUser(id));
	}
}
