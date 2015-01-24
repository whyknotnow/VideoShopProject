package com.videoshop.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.videoshop.Customer;

public class CustomerTest {

	@Test
	public void testGetName() {
		//SET UP 
		Customer customer = new Customer(1, "Caglar", "Akbulut");	
		String expectedName = "Caglar";
		String actualName = "";
		
		//EXERCISE SUT
		actualName = customer.getName();
		
		//VERIFY OUTPUT
		assertEquals(expectedName, actualName);
	}
	
	@Test
	public void testGetSurname() {
		//SET UP 
		Customer customer = new Customer(1, "Caglar", "Akbulut");	
		String expectedSurname = "Akbulut";
		String actualSurname = "";
		
		//EXERCISE SUT
		actualSurname = customer.getSurname();
		
		//VERIFY OUTPUT
		assertEquals(expectedSurname, actualSurname);
	}

}
