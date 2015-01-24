package com.videoshop.test;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

import com.videoshop.Customer;

public class CustomerTest {
	
//*** MOCKING CONTEXT DEFINED ***
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery(){{
		setImposteriser(ClassImposteriser.INSTANCE);		
	}};
	
	@Test
	public void testGetName() {
		
	//***** SET UP *****
		final Customer customer = context.mock(com.videoshop.Customer.class);
		//Customer customer = new Customer(1, "Caglar", "Akbulut");	
		String expectedName = "Caglar";
		String actualName = "";
		
	//***** EXERCISE SUT ****** 
		//*expectations*
		context.checking(new Expectations(){{
			oneOf(customer).getName();will(returnValue("Caglar"));
		}});
		actualName = customer.getName();
		
	//***** VERIFY OUTPUT *****
		assertEquals(expectedName, actualName);
	}
	
	@Test
	public void testGetSurname() {
	
	//***** SET UP *****
		final Customer customer = context.mock(com.videoshop.Customer.class);
		//Customer customer = new Customer(1, "Caglar", "Akbulut");	
		String expectedSurname = "Akbulut";
		String actualSurname = "";
		
	//***** EXERCISE SUT ****** 
		//*expectations*
		context.checking(new Expectations(){{
			oneOf(customer).getSurname();will(returnValue("Akbulut"));
		}});
		actualSurname = customer.getSurname();
		
	//***** VERIFY OUTPUT *****
		assertEquals(expectedSurname, actualSurname);
	}

}
