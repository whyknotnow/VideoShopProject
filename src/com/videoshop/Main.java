package com.videoshop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
	//loads configuration and creates a session factory
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	//opens a new session from the session factory (dbcontext)
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Caglar");
		customer.setSurname("Akbulut");
		
		Rental rental = new Rental();
		rental.setId(1);
		rental.setMovie_id(1);
		rental.setTotal_price(3.3);
		rental.setDays_rent(1);
		
		rental.setCustomer(customer);
		customer.getRentals().add(rental);
		
		session.save(customer);
		session.save(rental);
		
		session.getTransaction().commit();
		
		
		
	}

}
