package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Theatre;
import com.example.demo.service.TheatreServiceImpl;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
	
	@Autowired
	TheatreServiceImpl theatreServiceImpl;
	
	@PostMapping("/save")
	public Theatre postTheatre(@RequestBody Theatre theatre) {
		return theatreServiceImpl.postTheatre(theatre); 
	}

	@GetMapping("/get")
	public List<Theatre> getTheatreByMovieName(@RequestHeader String movieName) {
		return theatreServiceImpl.getTheatreByMovieName(movieName);
	}
	
	@GetMapping("/getseats")
	public Map<String, String> getTheatreByTheatreName(@RequestHeader String theatreName) {
		return theatreServiceImpl.getTheatreByTheatreName(theatreName);
	}
	
	@PostMapping("/bookTickets")
	public String bookSeats(@RequestHeader String theatreName, @RequestHeader String seatsForBooking) {
		return theatreServiceImpl.bookSeats(theatreName, seatsForBooking);
	}
}
