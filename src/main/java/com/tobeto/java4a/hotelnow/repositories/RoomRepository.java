package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
