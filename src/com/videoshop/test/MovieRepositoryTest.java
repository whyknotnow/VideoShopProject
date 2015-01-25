package com.videoshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.videoshop.model.Customer;
import com.videoshop.model.Movie;
import com.videoshop.repository.CustomerRepository;
import com.videoshop.repository.MovieRepository;
import com.videoshop.repository.SingletonSession;

public class MovieRepositoryTest {
	
	MovieRepository mRep = new MovieRepository();	
	
	@Test
	public void testGetAllMovies(){		
	//****** SET UP *****
		mRep.beginTransaction();
	//***** EXECUTE SUT *****
		List<Movie> movies = mRep.GetAllMovies();
		
	//***** VERIFY OUTPUT *****
		assertFalse(movies.isEmpty());
	}
	
	@Test
	public void testGetMovieByTitle(){
		
	//***** SET UP *****
		Movie expectedMovie = new Movie(1,"The Green Mile",5.99);
		
	//***** EXECUTE SUT *****
		Movie actualMovie = mRep.GetMovieByTitle("The Green Mile");
		
	//***** VERIFY OUTPUT *****
		assertEquals(expectedMovie, actualMovie);
	}
	
	@Test
	public void testInsertMovie(){
		
	//***** SET UP *****
		Movie movie = new Movie("Undisputed", 7.99);
		boolean value = false;
		
	//***** EXECUTE SUT *****
		value = mRep.InsertMovie(movie);
		
	//***** VERIFY OUTPUT *****
		assertTrue(value);
	}
	
	@Test
	public void testDeleteMovie(){
		
		//***** SET UP *****
			Movie movie = new Movie("The Green Mile", 7.99);
			boolean value = false;
		//***** EXECUTE SUT *****
			value = mRep.DeleteMovie(movie);
			
		//***** VERIFY OUTPUT *****
			assertTrue(value);
		}
	
	@AfterClass
	public static void cleanUp(){
		SingletonSession.End();
	}
}
