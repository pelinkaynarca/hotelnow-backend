package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_type_facility_categories")
public class RoomTypeFacilityCategory extends BaseEntity {
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "roomTypeFacilityCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeFacilityDetailOption> roomTypeFacilityDetailOptions;
}
