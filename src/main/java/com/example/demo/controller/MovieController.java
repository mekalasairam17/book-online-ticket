package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Movie;
import com.example.demo.service.MovieServiceImpl;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	@PostMapping("/save")
	public Movie SaveMovie(@RequestBody Movie movie) {
		return movieServiceImpl.saveMovie(movie);
	}

	@GetMapping("/get")
	public List<Movie> getMovie() {
		return movieServiceImpl.getMovies();
	}
	
	@PostMapping("/makeActiveOrInactive")
	public Boolean makeActiveOrInactive(@RequestHeader String movieName, @RequestHeader Boolean isActive) {
		return movieServiceImpl.makeMovieInactive(movieName, isActive);
	}
	
}