package com.tobeto.java4a.hotelnow.services.dtos.responses.hotels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListHotelResponse {
    private int id;

    private String name;

    private Byte stars;

    private String address;

    private String description;

    private String checkInTime;

    private String checkOutTime;

    private String neighborhoodName;
}
