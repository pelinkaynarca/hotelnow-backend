package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilitySelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MainFacilitySelectionRepository extends JpaRepository<MainFacilitySelection, Integer> {

    @Query("select mfs from MainFacilitySelection mfs where mfs.hotel.id = :hotelId")
    List<MainFacilitySelection> findByHotelId(@Param("hotelId") int hotelId);

    @Query("select mfs from MainFacilitySelection mfs where mfs.hotel.id = :hotelId and mfs.display = :display")
    List<MainFacilitySelection> findByHotelIdAndDisplay(@Param("hotelId") int hotelId, @Param("display") boolean display);

    @Query(value = "SELECT mfs FROM MainFacilitySelection mfs WHERE mfs.hotel.id = :hotelId AND mfs.display = true ORDER BY RANDOM() LIMIT 8")
    List<MainFacilitySelection> findRandomByHotelId(@Param("hotelId") int hotelId);
}
