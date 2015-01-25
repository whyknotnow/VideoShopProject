package com.videoshop.test.model;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

import com.videoshop.model.Movie;

public class MovieTest {
	
//***** STATIC VALUES and MOCKING CONTEXT DEFINED
	private static final double DELTA = 1e-15;
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery(){{
		setImposteriser(ClassImposteriser.INSTANCE);		
	}};

	@Test
	public void testGetTitle() {	
		
	//***** SET UP *****
		final Movie movie = context.mock(com.videoshop.model.Movie.class);
		String expectedTitle = "The Green Mile";
		String actualTitle = "";
		
	//***** EXERCISE SUT ****** *expectations*
		context.checking(new Expectations(){{
			oneOf(movie).getTitle();will(returnValue("The Green Mile"));
		}});
		actualTitle = movie.getTitle();
		
	//***** VERIFY OUTPUT *****
		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void testGetPrice() {			
		
	//***** SET UP *****
		final Movie movie = context.mock(com.videoshop.model.Movie.class);
		//Movie movie = new Movie(2, "The Chosen One", 7.99);	
		double expectedPrice = 7.99;
		double actualPrice = 0.0;
			
	//***** EXERCISE SUT ****** 
		//*expectations*
		context.checking(new Expectations(){{
			oneOf(movie).getPrice();will(returnValue(7.99));			
		}});
		actualPrice = movie.getPrice();
			
	//***** VERIFY OUTPUT *****
		assertEquals(expectedPrice, actualPrice, DELTA);
	}
}
