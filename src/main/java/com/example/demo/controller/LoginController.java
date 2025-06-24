package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserRequest;
import com.example.demo.service.LoginServiceImpl;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginServiceImpl ;
	
	@PostMapping("/register")
	public Object saveLogin(@RequestBody User user) {
		return	loginServiceImpl.saveLogin(user);
	}
	
	@GetMapping("/login")
	public Boolean isValidUser(@RequestBody UserRequest userRequest) {
		return loginServiceImpl.isValidUser(userRequest);
	}

}
