package com.videoshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.videoshop.model.Customer;
import com.videoshop.model.Movie;

public class MovieRepository implements IMovieRepository{

	Session session = SingletonSession.getSession();
	//this method begins the transaction for get, set, delete, update,...
	//this method should call only once.
	public void beginTransaction() {
		session.beginTransaction();		
	}
	
	@Override
	public List<Movie> GetAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "SELECT * FROM videoshopdb.movie";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Movie.class);		
		List results= query.list();
		
		for(int i=0; i<results.size();i++){
			Movie movie = (Movie)results.get(i);
			movies.add(movie);
		}
		
		return movies;
	}

	@Override
	public Movie GetMovieByTitle(String movieTitle) {
		// TODO Auto-generated method stub
		Movie movie = new Movie();
		
		String sql = "SELECT id, title, price "
				+ "FROM videoshopdb.movie "
				+ "WHERE title=" + "'" + movieTitle + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Movie.class);
		List results = query.list();		
		movie = (Movie)results.get(0);
		
		return movie;
	}

	@Override
	public boolean InsertMovie(Movie movie) {
		Integer value = (Integer) session.save(movie);
		if(value > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean DeleteMovie(Movie movie) {
		Movie willDeleted = this.GetMovieByTitle(movie.getTitle());
		session.delete(willDeleted);
		
		if(willDeleted.getTitle().isEmpty())
			return false;
		else
			return true;
	}

	//saves all changes to db
	/*
	public void Save() {
		session.getTransaction().commit();
	}*/
	
}
