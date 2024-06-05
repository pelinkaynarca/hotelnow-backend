package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b where b.customer.id = :customerId")
	List<Booking> findByCustomerId(@Param("customerId") int customerId);
	
	@Query("select b from Booking b where b.hotel.id = :hotelId")
	List<Booking> findByHotelId(@Param("hotelId") int hotelId);

}
