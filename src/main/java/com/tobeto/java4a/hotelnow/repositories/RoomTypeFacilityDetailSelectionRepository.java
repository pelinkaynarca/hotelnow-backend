package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailSelection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeFacilityDetailSelectionRepository extends JpaRepository<RoomTypeFacilityDetailSelection, Integer> {

    List<RoomTypeFacilityDetailSelection> findByRoomTypeIdAndDisplayTrue(int roomTypeId);
}
