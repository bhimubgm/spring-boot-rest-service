package com.springboot.rest.example.service;

import java.util.List;

import com.springboot.rest.example.entity.Message;

public interface MessageService {

	/**
	 * Retrieve the message for a particular user.
	 * @param id
	 * @param count
	 * @return Message list
	 */
	public List<Message> findByUserId(Long id, Integer count);

	/**
	 * Create new message entity
	 * @param message
	 * 
	 * @return Message
	 */
	public Message save(Message message, Long userId) throws Exception ;

}
