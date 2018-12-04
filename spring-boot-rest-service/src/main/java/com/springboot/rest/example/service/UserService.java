package com.springboot.rest.example.service;

import java.util.List;

import com.springboot.rest.example.entity.User;

public interface UserService {

	/**
	 * List all the users
	 * @return User list
	 */
	List<User> findAll();

	/**
	 * Create new user
	 * @param user
	 * @return User
	 */
	User save(User user);

	/**
	 * Get user by id
	 * @param id - user identifier
	 * @return User
	 */
	User getOne(Long id);

}
