package com.arif.repository;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.arif.domain.User;

@Repository
public class UserRepository {
	
	private List<User> users = new ArrayList<User>();
	
	private void initialiseUser(){
		User user1 = new User();
		user1.setName("Andrew Clark");
		user1.setPassword("popl*7!");
		user1.setUserName("AC");
		
		User user2 = new User();
		user2.setName("James Brokes");
		user2.setPassword("jAmplw");
		user2.setUserName("hodngre");
		
		User user3 = new User();
		user3.setName("Stephen Mark");
		user3.setPassword("Slopn7543!");
		user3.setUserName("smpoqwe");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	public User findUser(String userName){
		initialiseUser();
		return users.stream().filter(t -> t.getUserName().equalsIgnoreCase(userName)).findFirst().get();
		
	}

}
