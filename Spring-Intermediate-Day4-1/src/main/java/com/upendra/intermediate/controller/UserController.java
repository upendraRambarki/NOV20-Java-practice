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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	 @Operation(
	            summary = "Create User REST API",
	            description = "Create User REST API is used to save user in a database"
	    )
	 @ApiResponse(
	            responseCode = "201",
	            description = "HTTP Status 201 CREATED"
	    )
	@PostMapping("/post")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
	{
		UserDto user2 = userService.createUser(user);
		return ResponseEntity.ok(user2);
	}
	 @Operation(
	            summary = "Get User By ID REST API",
	            description = "Get User By ID REST API is used to get a single user from the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	    )
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable Long id)
	{
		UserDto user = userService.getByUserId(id);
		return ResponseEntity.ok(user);
	}
	 @Operation(
	            summary = "Get All Users REST API",
	            description = "Get All Users REST API is used to get a all the users from the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	    )
	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		List<UserDto> user = userService.getAllUsers();
		return ResponseEntity.ok(user);
	}
	 
	 @Operation(
	            summary = "Update User REST API",
	            description = "Update User REST API is used to update a particular user in the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	    )

	@PutMapping("update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody @Valid UserDto userDto)
	{
		userDto.setUserId(id);
		return ResponseEntity.ok(userService.updateUser(userDto));
	}
	 @Operation(
	            summary = "Delete User REST API",
	            description = "Delete User REST API is used to delete a particular user from the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	    )
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id)
	{
		
		return ResponseEntity.ok(userService.deleteUser(id));
	}
}
