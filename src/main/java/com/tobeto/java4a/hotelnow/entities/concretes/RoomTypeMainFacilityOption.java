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
@Table(name = "room_type_main_facility_options")
public class RoomTypeMainFacilityOption extends BaseEntity {
    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private RoomTypeMainFacilityCategory roomTypeMainFacilityCategory;

    @OneToMany(mappedBy = "roomTypeMainFacilityOption", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeMainFacilitySelection> roomTypeMainFacilitySelections;
}
