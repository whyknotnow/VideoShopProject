package com.videoshop.repository;

import java.util.List;

import com.videoshop.model.Customer;

public interface ICustomerRepository {
	List<Customer> GetAllCustomers();
	Customer GetCustomerByName(String customerName);
	boolean InsertCustomer(Customer customer);
	boolean DeleteCustomer(Customer customer);
	void Save();
}
