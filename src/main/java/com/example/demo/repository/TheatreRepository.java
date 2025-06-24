package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>{
	
	Theatre findByTheatreName(String theatreName);

}
