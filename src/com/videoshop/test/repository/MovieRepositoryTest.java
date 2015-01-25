package com.videoshop.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.videoshop.model.Movie;
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
		Movie expectedMovie = new Movie(2,"Men in Black",5.99);
		
	//***** EXECUTE SUT *****
		Movie actualMovie = mRep.GetMovieByTitle("Men in Black");
		
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
			Movie movie = new Movie("Men in Black", 7.99);
			boolean value = false;
		//***** EXECUTE SUT *****
			value = mRep.DeleteMovie(movie);
			
		//***** VERIFY OUTPUT *****
			assertTrue(value);
		}
	
	@AfterClass
	public static void cleanUp(){
		//This method destroys singleton context object, so other test classes can create 
		//and use context(session) object again.
		SingletonSession.End();
	}
}
