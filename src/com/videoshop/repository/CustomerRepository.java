package com.videoshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.videoshop.model.Customer;

public class CustomerRepository implements ICustomerRepository{

	Session session = SingletonSession.getSession();
	//this method begins the transaction for get, set, delete, update,...
	//this method should call only once.
	public void beginTransaction() {
		session.beginTransaction();		
	}
	
	@Override
	public List<Customer> GetAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		String sql = "SELECT * FROM videoshopdb.customer";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);		
		@SuppressWarnings("rawtypes")
		List results= query.list();
		
		for(int i=0; i<results.size();i++){
			Customer customer = (Customer)results.get(i);
			customers.add(customer);
		};
		return customers;
	}

	@Override
	public Customer GetCustomerByName(String customerName) {
		Customer customer = new Customer();
		
		String sql = "SELECT id, name, surname "
				+ "FROM videoshopdb.customer "
				+ "WHERE name=" + "'" + customerName + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);
		@SuppressWarnings("rawtypes")
		List results = query.list();		
		customer = (Customer)results.get(0);
		return customer;
	}

	@Override
	public boolean InsertCustomer(Customer customer) {
		Integer value = (Integer) session.save(customer);
		if(value > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean DeleteCustomer(Customer customer) {
		Customer willDeleted = this.GetCustomerByName(customer.getName());
		session.delete(willDeleted);
		if(willDeleted.getName().isEmpty())
			return false;
		else
			return true;
	}	
}
