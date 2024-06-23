package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeMainFacilitySelectionRepository extends JpaRepository<RoomTypeMainFacilitySelection, Integer> {

    List<RoomTypeMainFacilitySelection> findByRoomTypeId(int roomTypeId);
}
