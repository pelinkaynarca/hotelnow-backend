package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByRoomTypeId(int roomTypeId);

    Optional<Room> findByNo(int no);

    @Modifying
    @Transactional
    @Query("UPDATE RoomType rt SET rt.display = :display WHERE rt.id IN (SELECT r.roomType.id FROM Room r WHERE r.id = :roomId)")
    void updateRoomTypeDisplayStatusByRoomId(boolean display, int roomId);
}