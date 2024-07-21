package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.ReviewReply;
import com.tobeto.java4a.hotelnow.services.enums.ReviewReplyStatus;

public interface ReviewReplyRepository extends JpaRepository<ReviewReply, Integer> {

	@Query("select rr from ReviewReply rr where rr.review.id = :reviewId")
	List<ReviewReply> findByReviewId(@Param("reviewId") int reviewId);

	@Query("select rr from ReviewReply rr where rr.staff.id = :staffId")
	List<ReviewReply> findByStaffId(@Param("staffId") int staffId);

	@Query("select rr from ReviewReply rr where rr.review.id = :reviewId and rr.status = :status")
	List<ReviewReply> findByReviewIdAndStatus(@Param("reviewId") int reviewId,
			@Param("status") ReviewReplyStatus status);

	@Query("select rr from ReviewReply rr where rr.status = :status")
	List<ReviewReply> findByStatus(@Param("status") ReviewReplyStatus status);
}
