package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel_phones")
public class HotelPhone extends BaseEntity {

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
