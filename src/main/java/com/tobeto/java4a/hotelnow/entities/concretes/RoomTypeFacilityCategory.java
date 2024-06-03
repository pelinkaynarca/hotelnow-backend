package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_type_facility_categories")
public class RoomTypeFacilityCategory extends BaseEntity {
    @Column(name = "title")
    private String title;
}
