package com.arif.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arif.domain.User;

@RestController
public class MyController {
	
	@RequestMapping(value="/user")
	public User getUser(){
		
		User user = new User();
		user.setName("Arif");
		user.setPassword("MyPassWord");
		user.setUserName("MyUserName");
		return user;
	}

}
