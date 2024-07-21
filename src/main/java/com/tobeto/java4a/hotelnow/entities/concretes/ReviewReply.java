package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import com.tobeto.java4a.hotelnow.services.enums.ReviewReplyStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review_replies")
public class ReviewReply extends BaseEntity {

	@ManyToOne(optional = false)
	@JoinColumn(name = "review_id")
	private Review review;

	@ManyToOne(optional = false)
	@JoinColumn(name = "staff_id")
	private Staff staff;

	@Column(name = "reply", nullable = false)
	private String reply;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ReviewReplyStatus status;

	@Generated
	@ColumnDefault("now()")
	@Column(name = "replied_at", nullable = false, updatable = false)
	private LocalDateTime repliedAt;

}
