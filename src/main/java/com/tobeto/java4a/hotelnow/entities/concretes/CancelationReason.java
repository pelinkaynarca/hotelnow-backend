package com.tobeto.java4a.hotelnow.entities.concretes;

import java.util.List;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cancelation_reasons")
public class CancelationReason extends BaseEntity {

	@Column(name = "reason")
	private String reason;

	@OneToMany(mappedBy = "cancelationReason", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BookingHistory> bookingHistories;

}
