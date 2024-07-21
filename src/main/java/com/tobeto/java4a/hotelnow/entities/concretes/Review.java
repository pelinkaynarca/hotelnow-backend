package com.tobeto.java4a.hotelnow.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import com.tobeto.java4a.hotelnow.services.enums.ReviewStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review extends BaseEntity {

	@Column(name = "review")
	private String review;

	@Column(name = "rating", nullable = false)
	private byte rating;

	@Generated
	@ColumnDefault("now()")
	@Column(name = "reviewed_at", nullable = false, updatable = false)
	private LocalDateTime reviewedAt;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ReviewStatus status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne(optional = false)
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ReviewReply> reviewReplies;
}
