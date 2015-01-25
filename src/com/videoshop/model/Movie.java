package com.videoshop.model;

public class Movie {
	private int id;
	private String title;
	private double price;
	public Movie(int _id, String _title, double _price) {
		this.id=_id;
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
}
