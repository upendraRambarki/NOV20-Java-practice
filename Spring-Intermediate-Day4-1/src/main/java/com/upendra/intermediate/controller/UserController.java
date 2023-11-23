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

import com.upendra.intermediate.entity.User;
import com.upendra.intermediate.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/post")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user2 = userService.createUser(user);
		return ResponseEntity.ok(user2);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id)
	{
		User user = userService.getByUserId(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> user = userService.getAllUsers();
		return ResponseEntity.ok(user);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user)
	{
		user.setUserId(id);
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id)
	{
		
		return ResponseEntity.ok(userService.deleteUser(id));
	}
}
