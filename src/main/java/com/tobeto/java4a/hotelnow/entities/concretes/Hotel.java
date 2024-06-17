package com.tobeto.java4a.hotelnow.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "stars")
    private Byte stars;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(optional = false)
    @JoinColumn(name = "neighborhood_id")
    private Neighborhood neighborhood;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Staff> staffs;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelImage> hotelImages;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelPhone> hotelPhones;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MainFacilitySelection> mainFacilitySelections;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FacilityDetailSelection> facilityDetailSelections;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomType> roomTypes;
}
