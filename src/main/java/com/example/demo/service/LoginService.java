package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserRequest;

@Service
public interface LoginService  {
	
	Object saveLogin(User user);
	
    Boolean isValidUser(UserRequest userRequest);
	
}
