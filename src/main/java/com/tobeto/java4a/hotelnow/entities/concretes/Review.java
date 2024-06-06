package com.tobeto.java4a.hotelnow.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@Column(name = "reviewed_at", nullable = false)
	private LocalDateTime reviewedAt;

	@Column(name = "approved", nullable = false)
	private boolean approved;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ReviewReply> reviewReplies;
}
