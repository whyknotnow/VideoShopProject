package com.videoshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.videoshop.model.Customer;
import com.videoshop.repository.CustomerRepository;
import com.videoshop.repository.SingletonSession;

public class CustomerRepositoryTest {
	
	CustomerRepository cRep = new CustomerRepository();	
	@Test
	public void testGetAllCustomers(){		
	//****** SET UP *****
		cRep.beginTransaction();
	//***** EXECUTE SUT *****
		List<Customer> customers = cRep.GetAllCustomers();
		
	//***** VERIFY OUTPUT *****
		assertFalse(customers.isEmpty());
	}
	
	@Test
	public void testGetCustomerByName(){
		
	//***** SET UP *****
		Customer expectedCustomer = new Customer(1,"Caglar","Akbulut");
		
	//***** EXECUTE SUT *****
		Customer actualCustomer = cRep.GetCustomerByName("Caglar");
		
	//***** VERIFY OUTPUT *****
		assertEquals(expectedCustomer, actualCustomer);
	}
	
	@Test
	public void testInsertCustomer(){
		
	//***** SET UP *****
		Customer cust = new Customer("Osman","Ercelik");
		boolean value = false;
		
	//***** EXECUTE SUT *****
		value = cRep.InsertCustomer(cust);
		
	//***** VERIFY OUTPUT *****
		assertTrue(value);
	}
	
	@Test
	public void testDeleteCustomer(){
		
		//***** SET UP *****
			Customer cust = new Customer("Osman","Ercelik");
			boolean value = false;
		//***** EXECUTE SUT *****
			value = cRep.DeleteCustomer(cust);
			
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
