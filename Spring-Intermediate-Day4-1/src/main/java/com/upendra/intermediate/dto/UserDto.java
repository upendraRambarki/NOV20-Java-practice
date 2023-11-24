package com.upendra.intermediate.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private long userId;
	@NotEmpty
	String firstName;
	@NotEmpty
	String lastName;
	@NotEmpty
	@Email
	String email;

}
