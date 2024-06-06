package com.tobeto.java4a.hotelnow.repositories;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacilityDetailOptionRepository extends JpaRepository<FacilityDetailOption, Integer> {

   @Query("select fdo from FacilityDetailOption fdo where fdo.facilityCategory.id = :categoryId")
   List<FacilityDetailOption> findByCategoryId(@Param("categoryId") int categoryId);

}
