package com.upendra.intermediate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upendra.intermediate.dto.UserDto;
import com.upendra.intermediate.entity.User;
import com.upendra.intermediate.repository.UserRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	private ModelMapper modelMapper;

	/*
	 * @Override public User createUser(User user) {
	 * 
	 * return userRepository.save(user); }
	 */
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		
		  //to convert userDto to jpa
		  
			/*
			 * User user = new User( userDto.getUserId(), userDto.getFirstName(),
			 * userDto.getLastName(), userDto.getEmail() );
			 * 
			 * User savedUser = userRepository.save(user); System.out.println(savedUser);
			 * //to covert user to userDto UserDto saveUserDto = new UserDto(
			 * savedUser.getUserId(), savedUser.getFirstName(), savedUser.getLastName(),
			 * savedUser.getEmail());
			 * 
			 * return saveUserDto;
			 */
		 
		
		//to convert userDto to jpa
		//using mappers
		
				//User user = UserMapper.mapToUser(userDto);
		
		//using modelMappers
		
		User user = modelMapper.map(userDto, User.class);
		
				User savedUser = userRepository.save(user);
				
				//to covert user to userDto 
				//using mappers
//				UserDto saveUserDto = UserMapper.mapToUserDto(savedUser);
				
				//using modelMappers
			UserDto saveUserDto = modelMapper.map(savedUser, UserDto.class);
				
				return saveUserDto;
		
	}

	/*
	 * @Override public User getByUserId(Long Id) {
	 * 
	 * User userId = userRepository.findByUserId(Id);
	 * 
	 * return userId; }
	 */
	@Override
	public UserDto getByUserId(Long Id) {
		
		User userId = userRepository.findByUserId(Id);
		
		//using mappers
		//return UserMapper.mapToUserDto(userId);
		
		//using modelMappers
		return modelMapper.map(userId, UserDto.class);
	}

	
	/*
	 * @Override public List<User> getAllUsers() {
	 * 
	 * return userRepository.findAll(); }
	 */
	
	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> user = userRepository.findAll();
		
		//using Mappers
//		return user.stream().map(UserMapper::mapToUserDto)
//				.collect(Collectors.toList());
//		
		return user.stream().map((a)->modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	/*
	 * @Override public User updateUser(User user) {
	 * 
	 * User user2 = userRepository.findByUserId(user.getUserId());
	 * user2.setFirstName(user.getFirstName());
	 * user2.setLastName(user.getLastName()); user2.setEmail(user.getEmail());
	 * System.out.println(user2); User updatedUser = userRepository.save(user2);
	 * return updatedUser; }
	 */
	
	@Override
	public UserDto updateUser(UserDto user) {
		
		User user2 = userRepository.findByUserId(user.getUserId());
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setEmail(user.getEmail());
		System.out.println(user2);
		User updatedUser = userRepository.save(user2);
		
		//using mappers
//	return UserMapper.mapToUserDto(updatedUser);
		//using modelMappers
		return modelMapper.map(updatedUser, UserDto.class);
		
	}

	@Override
	public String deleteUser(long id) {
		User user2 = userRepository.findByUserId(id); 
		userRepository.delete(user2);
		return "deleted";
	}

}
