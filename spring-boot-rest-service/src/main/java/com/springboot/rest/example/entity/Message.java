package com.springboot.rest.example.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Message table entity.
 */
@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	@CreationTimestamp
	private Date timestamp;
	private String message;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	private User user;

	public Message() {
		super();
	}

	public Message(Long id, Date timestamp, String message, User user) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.message = message;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
