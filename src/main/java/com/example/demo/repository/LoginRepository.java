package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

public interface LoginRepository extends JpaRepository<User, Integer> {
	
	List<User> findAllByUserName(String name);

	
}
