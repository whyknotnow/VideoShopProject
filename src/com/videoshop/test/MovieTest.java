package com.videoshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.videoshop.Movie;

public class MovieTest {
	private static final double DELTA = 1e-15;

	@Test
	public void testGetTitle() {
		
	//***** SET UP *****
		Movie movie = new Movie(1, "The Green Mile", 5.99);	
		String expectedTitle = "The Green Mile";
		String actualTitle = "";
		
	//***** EXERCISE SUT ******
		actualTitle = movie.getTitle();
		
	//***** VERIFY OUTPUT *****
		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void testGetPrice() {			
			//***** SET UP *****
				Movie movie = new Movie(2, "The Chosen One", 7.99);	
				double expectedPrice = 7.99;
				double actualPrice = 0.0;
				
			//***** EXERCISE SUT ******
				actualPrice = movie.getPrice();
				
			//***** VERIFY OUTPUT *****
				assertEquals(expectedPrice, actualPrice, DELTA);
	}
}
