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
public class UpdateHotelResponse {

    private String name;

    private Byte stars;

    private String address;

    private String description;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private String neighborhoodName;
}
