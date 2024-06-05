package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailSelection;

public interface FacilityDetailSelectionRepository extends JpaRepository<FacilityDetailSelection, Integer>{
	
	@Query("select fds from FacilityDetailSelection fds where fds.hotel.id = :hotelId")
	List<FacilityDetailSelection> findByHotelId(@Param("hotelId") int hotelId);

	@Query("select fds from FacilityDetailSelection fds where fds.facilityDetailOption.id = :optionId")
	List<FacilityDetailSelection> findByOptionId(@Param("optionId") int optionId);
	
}
