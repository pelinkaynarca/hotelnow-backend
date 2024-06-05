package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.BookingHistory;

public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer>{
	
	@Query("select bh from BookingHistory bh where bh.booking.id = :bookingId")
	List<BookingHistory> findByBookingId(@Param("bookingId") int bookingId);

}
