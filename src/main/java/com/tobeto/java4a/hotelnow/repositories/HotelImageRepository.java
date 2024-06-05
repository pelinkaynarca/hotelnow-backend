package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelImageRepository extends JpaRepository<HotelImage, Integer> {

    @Query("select hi from HotelImage hi where hi.hotel.id = :hotelId")
    List<HotelImage> findByHotelId(@Param("hotelId") int hotelId);

}
