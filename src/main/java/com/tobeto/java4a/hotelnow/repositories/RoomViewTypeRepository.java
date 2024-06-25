package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomViewType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomViewTypeRepository extends JpaRepository<RoomViewType, Integer> {
    Optional<RoomViewType> findByNameIgnoreCase(String name);
}