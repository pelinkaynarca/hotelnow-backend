package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	@Query("select r from Review r where r.customer.id = :customerId")
	List<Review> findByCustomerId(@Param("customerId") int customerId);

}
