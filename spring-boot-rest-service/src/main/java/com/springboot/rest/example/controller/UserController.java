package com.springboot.rest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.entity.User;
import com.springboot.rest.example.service.UserService;
import com.springboot.rest.example.util.RestResponse;

/**
 * Controller for user entity related services.
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * Lists out all the users
	 * @return User list
	 */
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userService.findAll();
	}
	
	/**
	 * Create new user entity
	 * @param user - user to be created
	 * {
	 *     "name": "user1"
	 * }
	 * 
	 * @return RestResponse
	 */
	@PostMapping("/user")
	public RestResponse postUser(@RequestBody User user){
		try {
			this.userService.save(user);
			return new RestResponse("User has been created", "SUCCESS", null);
		} catch (Exception e) {
			return new RestResponse("Filed to create user", "ERROR", e.getMessage());
		}
	}
}
