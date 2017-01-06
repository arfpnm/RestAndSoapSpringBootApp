package com.arif;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.DispatcherServlet;

import com.arif.endpoint.UserServiceEndpoint;
import com.arif.service.UserService;

@SpringBootApplication
public class RestAndSoapApiApplication { //extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RestAndSoapApiApplication.class, args);
	}
	
	@Autowired
	private Bus bus;

	@Bean
	public ServletRegistrationBean dispatcherSoapServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
	}
	
	
//	@Bean
//	public DispatcherServlet dispatcherRestServlet() {
//		return new DispatcherServlet();
//	}

	@Bean
	public UserService userService() {
		return new UserServiceEndpoint();
	}

	@Bean
	public EndpointImpl endPoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, userService());
		endpoint.publish("/user");
		return endpoint;
	}

	@Bean(name=Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {      
		return new SpringBus();
	}
	
}
