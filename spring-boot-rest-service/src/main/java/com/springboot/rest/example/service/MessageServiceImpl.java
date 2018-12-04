package com.springboot.rest.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.rest.example.entity.Message;
import com.springboot.rest.example.entity.User;
import com.springboot.rest.example.repository.MessageRepository;

/**
 * Class that defines business logic for handling message entity
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserService userService;

	/**
	 * {@link MessageService.indByUserId(Long id, PageRequest pageRequest)}
	 */
	@Override
	public List<Message> findByUserId(Long id, Integer count) {
		return this.messageRepository.findByUserId(id, new PageRequest(0, count, Sort.Direction.DESC, "timestamp"));
	}

	/**
	 * {@link MessageService.save(Message message)}
	 */
	@Override
	public Message save(Message message, Long userId) throws Exception {
		User currentUser = this.userService.getOne(userId);
		if(Objects.isNull(currentUser)) throw new Exception("User not found");
		message.setUser(currentUser);
		return this.messageRepository.save(message);
	}

}
