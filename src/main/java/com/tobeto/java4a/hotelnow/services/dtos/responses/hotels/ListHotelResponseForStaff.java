package com.tobeto.java4a.hotelnow.services.dtos.responses.hotels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListHotelResponseForStaff {
    private int id;

    private String name;

    private byte stars;

    private String address;

    private String description;

    private boolean active;

    private String checkInTime;

    private String checkOutTime;

    private int neighborhoodId;

}
