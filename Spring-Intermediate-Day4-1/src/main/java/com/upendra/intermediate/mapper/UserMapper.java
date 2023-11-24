package com.upendra.intermediate.mapper;

import com.upendra.intermediate.dto.UserDto;
import com.upendra.intermediate.entity.User;

public class UserMapper {
	
	//to convert to jpa to userDto
	public static UserDto mapToUserDto(User user)
	{
		UserDto userDto = new UserDto(
				user.getUserId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);	
		
		return userDto;
	}
	
	//convert dto to user
	public static User mapToUser(UserDto userDto)
	{
		User user = new User(
				userDto.getUserId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);	
		
		return user;
	}
	

}
