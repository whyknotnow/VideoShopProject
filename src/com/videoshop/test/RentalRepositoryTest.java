package com.videoshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Test;

import com.videoshop.model.Customer;
import com.videoshop.model.Movie;
import com.videoshop.model.Rental;
import com.videoshop.repository.RentalRepository;
import com.videoshop.repository.SingletonSession;


public class RentalRepositoryTest {
	
	RentalRepository rRep = new RentalRepository();	
	
	
	@Test
	public void testGetAllRentals(){		
		
	//****** SET UP *****
		rRep.beginTransaction();
		
	//***** EXECUTE SUT *****
		List<Rental> rentals = rRep.GetAllRentals();
		
	//***** VERIFY OUTPUT *****
		assertFalse(rentals.isEmpty());
	}
	
	@Test
	public void testGetRentalById(){
		//****** SET UP *****
		int rentalId = 1;
		Rental rental = new Rental();
		
		//***** EXECUTE SUT *****
		rental = rRep.GetRentalById(1);
		
		//***** VERIFY OUTPUT *****
		assertEquals(1, rental.getId());
	}
	
	@Test
	public void testInsertRental(){
	
	//****** SET UP *****
		Customer customer = new Customer("Alper","Kilci");
		Movie movie = new Movie("Black 'n Yellow",6.99);
		
		//--set rental object for test
		Rental rental = new Rental();rental.setId(3);rental.setDays_rent(4);rental.setTotal_price(6.99*rental.getDays_rent());
		rental.setCustomer(customer);rental.setMovie(movie);
		//--end set rental object
		
		//--set rental's fk customer and movie
		Session session = SingletonSession.getSession();
		session.save(customer);session.save(movie);
		//--end set fk
		
	//***** VERIFY OUTPUT *****
		assertTrue(rRep.InsertRental(rental));	
		
	}
	
	@Test
	public void testDeleteRental(){
	
	//****** SET UP *****
		Rental rental = new Rental();rental.setId(1);
		boolean value = false;
		
	//***** EXERCISE SUT *****
		value = rRep.DeleteRental(rental);
		
	//***** VERIFY OUTPUT *****
		assertTrue(value);
	}
	
	@AfterClass
	public static void cleanUp(){
		//This method destroys singleton context object, so other test classes can create 
		//and use context(session) object again.
		Session session = SingletonSession.getSession();
		session.getTransaction().rollback();
		SingletonSession.End();
	}
	
	
}
