package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes;

import com.tobeto.java4a.hotelnow.services.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomTypeResponse {

    private int id;

    private String name;

    private double pricePerNight;

    private int size;

    private int bedTypeId;

    private int viewTypeId;

    private String description;

    private byte capacity;

    private boolean display;

    private Currency currency;
}
