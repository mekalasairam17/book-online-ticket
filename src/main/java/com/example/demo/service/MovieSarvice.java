package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.Movie;

@Service
public interface MovieSarvice   {
	
	Movie saveMovie(Movie movie);
	
	List<Movie> getMovies();
	
	Boolean makeMovieInactive(String movieName, Boolean isActive);

}
