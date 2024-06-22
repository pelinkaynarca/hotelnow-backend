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
@Table(name = "room_type_main_facility_categories")
public class RoomTypeMainFacilityCategory extends BaseEntity {

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "roomTypeMainFacilityCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeMainFacilityOption> roomTypeMainFacilityOptions;
}
