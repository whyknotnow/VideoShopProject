package com.videoshop.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SingletonSession {
	
	//***** create a single Session context 
	//***** to use everywhere. (kind of unit of work pattern)
	
//***** loads configuration and creates a session factory
	static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	static StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder()
								.applySettings(configuration.getProperties());
	static SessionFactory sessionFactory = configuration.buildSessionFactory(
			registry.build());
			
	//opens a new session from the session factory (dbcontext)
	private static Session session = sessionFactory.openSession();	
	
	private SingletonSession(){
	}
	
	public static Session getSession(){		
		if(session.isOpen())
			return session;
		else{
			session = sessionFactory.openSession();
			return session;
		}
			
		
	}
	
	public static void End(){
		session.close();
	}	
	
	public static void save(){
		session.getTransaction().commit();
	}
	
	
}
