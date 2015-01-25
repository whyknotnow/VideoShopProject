package com.videoshop.repository;

import java.util.List;

import com.videoshop.model.Movie;

public interface IMovieRepository {
	List<Movie> GetAllMovies();
	Movie GetMovieByTitle(String movieTitle);
	boolean InsertMovie(Movie movie);
	boolean DeleteMovie(Movie movie);
	//void Save();
}
