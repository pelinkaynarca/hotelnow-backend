package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelPhoneRepository extends JpaRepository<HotelPhone, Integer> {

    @Query("select hp from HotelPhone hp where hp.hotel.id = :hotelId")
    List<HotelPhone> findByHotelId(@Param("hotelId") int hotelId);

}
