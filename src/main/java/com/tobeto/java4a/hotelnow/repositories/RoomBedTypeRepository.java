package com.tobeto.java4a.hotelnow.repositories;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomBedType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomBedTypeRepository extends JpaRepository<RoomBedType, Integer> {
    Optional<RoomBedType> findByNameIgnoreCase(String name);
}
