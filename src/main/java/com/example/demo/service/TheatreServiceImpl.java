package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Theatre;
import com.example.demo.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	TheatreRepository theatreRepository;

	@Override
	public Theatre postTheatre(Theatre theatre) {
		theatre.setBooked("");
		String nonBooked = "";
        for (int i = 1; i <= 50; i++) {
        	nonBooked = nonBooked + i + ",";
        }
		theatre.setNonBooked(nonBooked);
		return theatreRepository.save(theatre);
	}

	@Override
	public List<Theatre> getTheatreByMovieName(String movieName) {
		List<Theatre> theatresInDB = theatreRepository.findAll();
		List<Theatre> finalList = new ArrayList<>();
		for(Theatre theatre : theatresInDB) {
			String moviesInDB = theatre.getMovies()+",";
			if(moviesInDB.contains(movieName+",")) {
				finalList.add(theatre);
			}
		}
		return finalList;
	}

	@Override
	public Map<String, String> getTheatreByTheatreName(String theatreName) {
		Theatre theatre = theatreRepository.findByTheatreName(theatreName);
		Map<String, String> result = new HashMap<>();
		result.put("booked", theatre.getBooked());
		result.put("nonBooked", theatre.getNonBooked());
		return result;
	}

	@Override
	public String bookSeats(String theatreName, String seatsForBooking) {
		Theatre theatre = theatreRepository.findByTheatreName(theatreName);
		String booked = theatre.getBooked();
		String[] bookedArray = booked.split(",");
		List<String> bookedList = new ArrayList<>(Arrays.asList(bookedArray));
		
		String nonBooked = theatre.getNonBooked();
		String[] nonBookedArray = nonBooked.split(",");
		List<String> nonBookedList = new ArrayList<>(Arrays.asList(nonBookedArray));
		
		String[] seatsForBookingArray = seatsForBooking.split(",");
		List<String> seatsForBookingList = new ArrayList<>(Arrays.asList(seatsForBookingArray));
		
		for(String seatForBooking : seatsForBookingList) {
			if(bookedList.contains(seatForBooking)) {
				return "please select valid tickets, dont select booked tickets";
			}
		}
		
		for(String seatForBooking : seatsForBookingList) {
			nonBookedList.remove(seatForBooking);
			bookedList.add(seatForBooking);
		}
		
		String bookedTickets = String.join(",", bookedList);
		theatre.setBooked(bookedTickets);
		String nonBookedTickets = String.join(",", nonBookedList);
		theatre.setNonBooked(nonBookedTickets);
		theatreRepository.save(theatre);
		return "Your tickets booked successfully, Enjoy.. the movie";
	}

}
