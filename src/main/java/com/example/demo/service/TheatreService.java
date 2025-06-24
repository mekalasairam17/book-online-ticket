package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.Theatre;

@Service
public interface TheatreService {
	
	Theatre postTheatre(Theatre theatre);
	
	public List<Theatre> getTheatreByMovieName(String movieName);
	
	Map<String, String> getTheatreByTheatreName(String theatreName);
	
	String bookSeats(String theatreName, String seatsForBooking);

}
