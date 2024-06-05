package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Integer> {

    @Query("select n from Neighborhood n where n.district.id = :districtId")
    List<Neighborhood> findByDistrictId(@Param("districtId") int districtId);

}
