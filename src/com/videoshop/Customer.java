package com.videoshop;

import java.util.HashSet;
import java.util.Set;

public class Customer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String surname;
	private Set<Rental> rentals = 
			new HashSet<Rental>(0);
	
	public Customer(){}
	
	public Customer(String _name, String _surname){
		this.name=_name;
		this.surname=_surname;
	}
	
	public Customer(int _id, String _name, String _surname){
		this.id = _id;
		this.name=_name;
		this.surname=_surname;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Set<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}
	
	
}
