package com.videoshop.test.model;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

import com.videoshop.model.Rental;

public class RentalTest {
	//SET DELTA VALUE FOR DOUBLE PRECISION
	private static final double DELTA = 1e-15;
	
	//*** SET UP MOCKING CONTEXT
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery(){{
		setImposteriser(ClassImposteriser.INSTANCE);		
	}};
	
	@Test
	public void testGetRentalDays(){
		
		//***** SET UP *****
			final Rental rental = context.mock(com.videoshop.model.Rental.class);
			int expectedDays = 5;
			int actualDays = 0;
			
		//***** EXERCISE SUT ****** *expectations
			context.checking(new Expectations(){{
				oneOf(rental).getDays_rent();will(returnValue(5));
			}});
			actualDays = rental.getDays_rent();
			
		//***** VERIFY OUTPUT *****
			assertEquals(expectedDays, actualDays);
	}
	
	@Test
	public void testGetTotalPrice(){
		
		//***** SET UP *****
			final Rental rental = context.mock(com.videoshop.model.Rental.class);
			double expectedPrice = 29.99;
			double actualPrice = 0;
			
		//***** EXERCISE SUT ****** 
			//*expectations
			context.checking(new Expectations(){{
				oneOf(rental).getTotal_price();will(returnValue(29.99));
			}});
			actualPrice = rental.getTotal_price();
			
		//***** VERIFY OUTPUT *****
			assertEquals(expectedPrice, actualPrice, DELTA);
	}
}
