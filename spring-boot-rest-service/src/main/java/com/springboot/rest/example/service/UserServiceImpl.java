package com.springboot.rest.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.example.entity.User;
import com.springboot.rest.example.repository.UserRepository;


/**
 * Class that defines business logic for handling user entity
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * {@link UserService.findAll()}
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * {@link UserService.save(User user)}
	 */
	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	/**
	 * {@link UserService.getOne(id)}
	 */
	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.getOne(id);
	}

}
