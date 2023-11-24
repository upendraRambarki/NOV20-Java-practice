package com.upendra.intermediate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(
        description = "UserDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private long userId;
	@NotEmpty(message= "user first name not be empty")
	@Schema(
            description = "User First Name"
    )
	String firstName;
	@Schema(
            description = "User Last Name"
    )
	@NotEmpty(message= "user last name not be empty")
	String lastName;
	 @Schema(
	            description = "User Email Address"
	    )
	@NotEmpty(message = "user email not be empty")
	@Email(message = "Email address should be valid")
	String email;

}
