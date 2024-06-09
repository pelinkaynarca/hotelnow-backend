package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    Optional<RoomType> findById(int id);
}
