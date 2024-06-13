package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.Review;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponseByHotelId;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query("select r from Review r where r.customer.id = :customerId")
	List<Review> findByCustomerId(@Param("customerId") int customerId);

//	@Query(value = "select r.* from reviews r"
//			+ " join bookings b on r.booking_id=b.id"
//			+ " join hotels h on b.hotel_id=h.id"
//			+ " where h.id = :hotelId", nativeQuery = true)
//	List<Review> findByHotelId(@Param("hotelId") int hotelId);

	// TODO Pagination in ReviewRepository
	@Query(nativeQuery = true, value = """
			SELECT b.customer_id,r.review,r.rating,r.reviewed_at,u.first_name,u.last_name,h.name AS hotel_name
			FROM reviews r
			JOIN bookings b ON r.booking_id = b.id
			JOIN hotels h ON b.hotel_id = h.id
			JOIN customers c ON b.customer_id = c.id
			JOIN users u ON c.id = u.id
			WHERE r.status = :reviewStatus AND b.hotel_id = :hotelId
			LIMIT 10
			""")
	List<ListReviewResponseByHotelId> findByHotelId(@Param("hotelId") int hotelId,
			@Param("reviewStatus") String reviewStatus);

}
