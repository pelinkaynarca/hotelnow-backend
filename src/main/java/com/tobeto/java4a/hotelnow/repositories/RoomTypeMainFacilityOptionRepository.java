package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilityOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomTypeMainFacilityOptionRepository extends JpaRepository<RoomTypeMainFacilityOption,Integer> {

    @Query("select rtmfo from RoomTypeMainFacilityOption rtmfo where rtmfo.roomTypeMainFacilityCategory.id = :categoryId")
    List<RoomTypeMainFacilityOption> findByCategoryId(@Param("categoryId") int categoryId);
}
