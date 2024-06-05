package com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBookedRoomTypeResponse {

    private int id;

    private String bookingName;

    private String roomTypeName;

    private int roomCount;
}
