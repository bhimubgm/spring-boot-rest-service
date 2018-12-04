package com.springboot.rest.example.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.entity.Message;
import com.springboot.rest.example.entity.User;
import com.springboot.rest.example.service.MessageService;
import com.springboot.rest.example.service.UserService;
import com.springboot.rest.example.util.RestResponse;

/**
 * Controller for message entity related services.
 */
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	/**
	 * Retrieves recent message.
	 * 
	 * @param userId - messages are returned for the given user id - if no value passed, default is set to -1 to avoid db query exceptions.
	 * @param count - maximum number of records to be returned - if no value passed, default is set to 100.
	 * -- /messages/?user_id=1&count=100
	 * 
	 * @return Messages list.
	 */
	@GetMapping("/messages")
	public List<Message> getMessages(@RequestParam(name = "user_id",  defaultValue = "-1") Long userId,
			@RequestParam(name = "count",  defaultValue = "100") Integer count){
		
		return this.messageService.findByUserId(userId, count);
	}

	/**
	 * Saves new message posted by user.
	 * 
	 * @param message - Message to be posted.
	 * @param userId - User who is posting the message - If invalid, exception is thrown.
	 * {
	 *     "message": "user message"
	 * }
	 * 
	 * @return RestResponse
	 */
	@PostMapping("/message/{user_id}")
	public RestResponse postMessage(@RequestBody Message message, @PathVariable(name = "user_id",  required = true) Long userId){
		try {
			this.messageService.save(message, userId);
			return new RestResponse("Message has been created", "SUCCESS", null);
		} catch (Exception e) {
			return new RestResponse("Filed to create message", "ERROR", e.getMessage());
		}
	}
}
