package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{
	
	@Query("select s from Staff s where s.hotel.id = :hotelId")
	List<Staff> findByHotelId(@Param("hotelId") int hotelId);

}
