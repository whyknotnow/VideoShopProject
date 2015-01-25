package com.videoshop.test.repository;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import com.videoshop.model.Customer;
import com.videoshop.model.Movie;
import com.videoshop.model.Rental;
import com.videoshop.repository.ICustomerRepository;
import com.videoshop.repository.IMovieRepository;
import com.videoshop.repository.IRentalRepository;

public class MockRepository {
	
	Mockery mockContext = new Mockery();
	
	private ICustomerRepository cRep;
	private IMovieRepository mRep;
	private IRentalRepository rRep;
	
	private Movie movie;
	private Customer customer;
	private Rental rental;
	
	@Test
	public void testCustomerRepository(){
	
	//***** SET UP FIXTURE ****
		customer = new Customer();
		
		//set up mock
		cRep= mockContext.mock(ICustomerRepository.class);
		mockContext.checking(new Expectations(){{
			oneOf (cRep).GetCustomerByName("Caglar"); will(returnValue(customer));
		}});
		
	//***** EXERCISE SUT *****
		cRep.GetCustomerByName("Caglar");
		
	//**** VERIFY OUTPUT *****
		mockContext.assertIsSatisfied();
	}
	
	@Test
	public void testMovieRepository(){
	
	//***** SET UP FIXTURE ****
		movie = new Movie();
		
		//set up mock
		mRep= mockContext.mock(IMovieRepository.class);
		mockContext.checking(new Expectations(){{
			oneOf (mRep).GetMovieByTitle("The Green Mile"); will(returnValue(movie));
		}});
		
	//***** EXERCISE SUT *****
		mRep.GetMovieByTitle("The Green Mile");
		
	//**** VERIFY OUTPUT *****
		mockContext.assertIsSatisfied();
	}
	
	@Test
	public void testRentalRepository(){
	
	//***** SET UP FIXTURE ****
		rental = new Rental();
		
		//set up mock
		rRep= mockContext.mock(IRentalRepository.class);
		mockContext.checking(new Expectations(){{
			oneOf (rRep).GetRentalById(3); will(returnValue(rental));
		}});
		
	//***** EXERCISE SUT *****
		rRep.GetRentalById(3);
		
	//**** VERIFY OUTPUT *****
		mockContext.assertIsSatisfied();
	}
	
}
