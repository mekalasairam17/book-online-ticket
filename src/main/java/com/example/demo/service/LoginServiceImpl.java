package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserRequest;
import com.example.demo.repository.LoginRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public Object saveLogin(User user) {
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			return "passwords are not matching";
		}
		return loginRepository.save(user);
	}

	@Override
	public Boolean isValidUser(UserRequest userRequest) {
		 List<User> users = loginRepository.findAllByUserName(userRequest.getUserName());
		 for(User user: users) {
			 if(user.getPassword().equals(userRequest.getPassword())) {
				 return true;
			 }
		 }
		 return false;
	}

}
