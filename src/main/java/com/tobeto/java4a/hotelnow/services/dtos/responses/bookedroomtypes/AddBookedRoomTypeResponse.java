package com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookedRoomTypeResponse {

    private int id;

    private int bookingId;

    private int roomTypeId;

    private int roomCount;
}
