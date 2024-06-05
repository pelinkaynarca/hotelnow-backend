package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedRoomTypeRepository extends JpaRepository<BookedRoomType, Integer> {
}
