package com.videoshop.model;

import java.util.HashSet;
import java.util.Set;

public class Movie {
	private int id;
	private String title;
	private double price;
	private Set<Rental> rentals = 
			new HashSet<Rental>(0);
	
	public Movie(){}
	
	public Movie(int _id, String _title, double _price) {
		this.id=_id;
		this.title=_title;
		this.price=_price;
	}
	
	public Movie(String _title, double _price) {
		this.title=_title;
		this.price=_price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Rental> getRentals() {
		return rentals;
	}
	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Movie))
			return false;
		if(obj==this)
			return true;
		
		Movie movie = (Movie) obj;
		
		if(movie.getTitle().equals(this.title))
			return true;
		else
			return false;
	}
}
