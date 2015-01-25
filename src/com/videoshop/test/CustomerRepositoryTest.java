package com.videoshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.videoshop.model.Customer;
import com.videoshop.repository.CustomerRepository;

public class CustomerRepositoryTest {
	
	CustomerRepository cRep = new CustomerRepository();	
	
	@Test
	public void testGetAllCustomers(){		
	//****** SET UP *****
		cRep.BeginTransaction();
		
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
}
