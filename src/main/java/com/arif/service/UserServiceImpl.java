package com.arif.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.arif.domain.User;
import com.arif.repository.UserRepository;

@Service
public class UserServiceImpl extends SpringBeanAutowiringSupport implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserName(String name) {
		return userRepository.findUser(name);
		
	}

}
