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
@Table(name = "cancellation_reasons")
public class CancellationReason extends BaseEntity {

	@Column(name = "reason" , nullable = false, updatable = false)
	private String reason;

	@OneToMany(mappedBy = "cancellationReason", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Booking> bookings;

}
