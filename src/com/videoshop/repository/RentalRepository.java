package com.videoshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.videoshop.model.Rental;

public class RentalRepository implements IRentalRepository{

	Session session = SingletonSession.getSession();
	//this method begins the transaction for get, set, delete, update,...
	//this method should call only once.
	public void beginTransaction() {
		session.beginTransaction();		
	}
	
	@Override
	public List<Rental> GetAllRentals() {
		List rentals = new ArrayList<>();
		String sql = "SELECT * FROM videoshopdb.rental";
		SQLQuery query = session.createSQLQuery(sql);
		List results=query.list();
		
		for(int i=0; i<results.size();i++){
			Object rental = results.get(i);
			rentals.add(rental);
		};
		
		return rentals;
	}

	@Override
	public Rental GetRentalById(int rentalId) {
		Rental rental = new Rental();
		String sql = "SELECT * "
				+ "FROM videoshopdb.rental "
				+ "WHERE id=" +rentalId;
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Rental.class);
		List results = query.list();		
		rental = (Rental)results.get(0);
		return rental;
	}

	@Override
	public boolean InsertRental(Rental rental) {
		Integer value = (Integer) session.save(rental);
		if(value > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean DeleteRental(Rental rental) {
		Rental willDeleted = this.GetRentalById(rental.getId());
		session.delete(willDeleted);
		if(willDeleted.getId() < 0)
			return false;
		else
			return true;
	}
}
