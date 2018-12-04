package com.springboot.rest.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.example.SpringBootRestServiceApplication;
import com.springboot.rest.example.entity.Message;
import com.springboot.rest.example.entity.User;
import com.springboot.rest.example.service.MessageService;
import com.springboot.rest.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestServiceApplication.class)
public class SpringBootRestServiceApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageService messageService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getUsersTest(){
		Assert.assertNotNull(this.userService.findAll());
	}
	
	@Test 
	public void saveTest(){
		User user = new User(null, "test user");
		Assert.assertNotNull(this.userService.save(user));
	}
	
	@Test
	public void getOneTest(){
		Assert.assertNotNull(this.userService.getOne(1L));
	}

	@Test
	public void findByUserIdTest(){
		Assert.assertNotNull(this.messageService.findByUserId(1L, 100));
	}

	@Test
	public void saveMessageTest(){
		Message message = new Message(null, null, "Test message", null);
		try {
			Assert.assertNotNull(this.messageService.save(message, 1L));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
}
