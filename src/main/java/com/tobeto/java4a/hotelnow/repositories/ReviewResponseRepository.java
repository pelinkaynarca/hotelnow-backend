package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.ReviewResponse;

public interface ReviewResponseRepository extends JpaRepository<ReviewResponse, Integer> {
	
	@Query("select rr from ReviewResponse rr where rr.review.id = :reviewId")
	List<ReviewResponse> findByReviewId(@Param("reviewId") int reviewId);
	
	@Query("select rr from ReviewResponse rr where rr.staff.id = :staffId")
	List<ReviewResponse> findByStaffId(@Param("staffId") int staffId);

}
