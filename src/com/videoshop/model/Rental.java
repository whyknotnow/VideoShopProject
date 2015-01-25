package com.videoshop.model;

public class Rental implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int movie_id;
	private int days_rent;
	private double total_price;
	private Customer customer;
	private Movie movie;
	
	public Rental(){}
	
	public Rental(int _id, int _movie_id,
			int _days_rent, double _total_price){
		this.id=_id;
		this.movie_id=_movie_id;
		this.days_rent=_days_rent;
		this.total_price=_total_price;
	}
	
	public Rental(int _movie_id,
			int _days_rent, double _total_price){
		this.movie_id=_movie_id;
		this.days_rent=_days_rent;
		this.total_price=_total_price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getDays_rent() {
		return days_rent;
	}
	public void setDays_rent(int days_rent) {
		this.days_rent = days_rent;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
