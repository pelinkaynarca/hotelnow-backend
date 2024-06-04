package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "room_type_facility_detail_options")
public class RoomTypeFacilityDetailOption  extends BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RoomTypeFacilityCategory roomTypeFacilityCategory;

    @OneToMany(mappedBy = "roomTypeFacilityDetailOption", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeFacilityDetailSelection> roomTypeFacilityDetailSelections;
}
