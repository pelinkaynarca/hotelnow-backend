package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomTypeFacilityDetailOptionRepository extends JpaRepository<RoomTypeFacilityDetailOption, Integer> {

    @Query("select rtfdo from RoomTypeFacilityDetailOption rtfdo where rtfdo.category.id = :categoryId")
    List<RoomTypeFacilityDetailOption> findByCategoryId(@Param("categoryId") int categoryId);

}
