package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @Column(name = "title" , nullable = false)
    private String title;

    @OneToMany(mappedBy = "roomTypeMainFacilityOption", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeMainFacilitySelection> roomTypeMainFacilitySelections;
}
