package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.entities.concretes.HotelPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("select h from Hotel h where h.neighborhood.id = :neighborhoodId")
    List<Hotel> findByNeighborhoodId(@Param("neighborhoodId") int neighborhoodId);

    List<Hotel> findByActive(boolean active);

    List<Hotel> findByStars(Byte stars);

}
