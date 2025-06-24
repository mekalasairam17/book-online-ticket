package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieSarvice {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getMovies() {
		 List<Movie> movies = movieRepository.findAll();
		 List<Movie> activeMovies = new ArrayList<>();
		 for(Movie movie : movies) {
			 Boolean isActive = movie.getIsActive();
			 if(isActive) {
				 activeMovies.add(movie);
			 }
		 }
		 return activeMovies;
	}

	@Override
	public Boolean makeMovieInactive(String movieName, Boolean isActive) {
		List<Movie> movies = movieRepository.findAllByMovieName(movieName);
		for(Movie movie : movies) {
			movie.setIsActive(isActive);
		}
		movieRepository.saveAll(movies);
		return true;
	}

}
