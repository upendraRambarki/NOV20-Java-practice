package com.upendra.intermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upendra.intermediate.entity.User;
import com.upendra.intermediate.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getByUserId(Long Id) {
		
		User userId = userRepository.findByUserId(Id);
		
		return userId;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		
		User user2 = userRepository.findByUserId(user.getUserId());
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setEmail(user.getEmail());
		System.out.println(user2);
		User updatedUser = userRepository.save(user2);
		return updatedUser;
	}

	@Override
	public String deleteUser(long id) {
		User user2 = userRepository.findByUserId(id); 
		userRepository.delete(user2);
		return "deleted";
	}

}
