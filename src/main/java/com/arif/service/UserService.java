package com.arif.service;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import com.arif.domain.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService
@Component
public interface UserService {
    @WebMethod User getUserName(@WebParam(name="name") String name);
	//User getUserName(String name);
}
