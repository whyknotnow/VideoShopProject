package com.videoshop;

public class Customer {
	private int id;
	private String name;
	private String surname;
	
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
	
	
}
