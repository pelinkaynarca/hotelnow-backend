package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("select h from Hotel h where h.neighborhood.id = :neighborhoodId")
    List<Hotel> findByNeighborhoodId(@Param("neighborhoodId") int neighborhoodId);

    List<Hotel> findByActive(boolean active);

    List<Hotel> findByStars(Byte stars);

    @Query(value = "SELECT h.* " +
            "FROM hotels h " +
            "JOIN neighborhoods n ON h.neighborhood_id = n.id " +
            "JOIN districts d ON n.district_id = d.id " +
            "JOIN cities c ON d.city_id = c.id " +
            "JOIN room_types rt ON h.id = rt.hotel_id " +
            "WHERE (:cityId IS NULL OR c.id = :cityId) " +
            "AND (:capacity IS NULL OR rt.capacity >= :capacity) " +
            "AND (:stars IS NULL OR h.stars = :stars) " +
            "AND h.active = true",
            nativeQuery = true)
    List<Hotel> findByFilter(@Param("cityId") Integer cityId, @Param("capacity") Byte capacity, @Param("stars") Byte stars);

}
