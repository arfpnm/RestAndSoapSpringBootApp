package com.arif.endpoint;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.arif.domain.User;
import com.arif.service.UserService;

//@WebService
public class UserServiceEndpoint implements UserService{
	
	@Autowired
	UserService userService;
	
	public User getUserName(String name){
		return userService.getUserName(name);
	}
	

}
