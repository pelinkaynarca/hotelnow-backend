package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
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
@Table(name = "room_types")
public class RoomType extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "capacity", nullable = false)
    private byte capacity;

    @Column(name = "display", nullable = false)
    private boolean display;

    @Column(name = "size", nullable = false)
    private int size;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeImage> roomTypeImages;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomTypeFacilityDetailSelection> roomTypeFacilityDetailSelections;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookedRoomType> bookedRoomTypes;

    @ManyToOne
    @JoinColumn(name = "bed_type_id", nullable = false)
    private RoomBedType roomBedType;

    @ManyToOne
    @JoinColumn(name = "view_type_id", nullable = false)
    private RoomViewType roomViewType;
}
