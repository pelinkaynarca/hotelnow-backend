package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cancelation_reasons")
public class CancelationReason extends BaseEntity {
    @Column(name = "reason")
    private String reason;

    @OneToMany
    private List<BookingHistory> bookingHistories;
}
