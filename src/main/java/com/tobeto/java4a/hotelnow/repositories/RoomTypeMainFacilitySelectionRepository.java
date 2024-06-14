package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomTypeMainFacilitySelectionRepository extends JpaRepository<RoomTypeMainFacilitySelection, Integer> {

    List<RoomTypeMainFacilitySelection> findByRoomTypeId(@Param("roomTypeId") int roomTypeId);
}
