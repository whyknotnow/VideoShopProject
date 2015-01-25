package com.videoshop.repository;

import java.util.List;

import com.videoshop.model.Rental;

public interface IRentalRepository {
	List<Rental> GetAllRentals();
	Rental GetRentalById(int rentalId);
	boolean InsertRental(Rental rental);
	boolean DeleteRental(Rental rental);
	//void Save();
}
