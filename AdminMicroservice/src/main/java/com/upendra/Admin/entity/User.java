package com.upendra.Admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private long userId;
	
	String firstName;
	
	String lastName;
	
	String email;
}
