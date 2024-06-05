package com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookedRoomTypeRequest {

    @Min(value = 1)
    private int id;

    @Min(value = 1)
    private int bookingId;

    @Min(value = 1)
    private int roomTypeId;

    @Min(value = 1)
    private int roomCount;
}
