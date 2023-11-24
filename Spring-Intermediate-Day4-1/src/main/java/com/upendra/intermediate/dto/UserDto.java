package com.upendra.intermediate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private long userId;
	String firstName;
	
	String lastName;
	
	String email;

}
