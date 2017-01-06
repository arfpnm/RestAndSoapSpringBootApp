package com.arif;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.arif.domain.User;
import com.arif.service.UserService;

public class SoapClient {
	
	
	public static void main(String args[]) throws Exception {

   	
    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    	factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
    	factory.setServiceClass(UserService.class);
    	factory.setAddress("http://localhost:8080/soap-api/user");
    	UserService userService = (UserService) factory.create();
    	
    	User user = userService.getUserName("AC");
    	System.out.println("User password : " + user.getPassword() + ", User Name is :  " + user.getUserName());
    	System.exit(0);

    }

}
