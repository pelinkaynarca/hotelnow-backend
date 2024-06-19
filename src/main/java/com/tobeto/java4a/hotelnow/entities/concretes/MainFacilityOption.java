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
@Table(name = "main_facility_options")
public class MainFacilityOption extends BaseEntity {
	
    @Column(name = "title" , nullable = false)
    private String title;

    @OneToMany(mappedBy = "mainFacilityOption", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MainFacilitySelection> mainFacilitySelections;
    
}
