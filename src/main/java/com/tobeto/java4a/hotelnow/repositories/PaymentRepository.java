package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query("select p from Payment p where p.booking.id = :bookingId")
	List<Payment> findByBookingId(@Param("bookingId") int bookingId);

}
