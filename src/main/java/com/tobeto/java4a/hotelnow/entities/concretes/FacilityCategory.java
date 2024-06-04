package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facility_categories")
public class FacilityCategory extends BaseEntity {
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "facilityCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FacilityDetailOption> facilityDetailOptions;
}
