package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomTypeResponse {

    private int id;

    private String name;

    private double pricePerNight;

    private String description;

    private byte capacity;

    private boolean display;

    private Currency currency;

    List<RoomTypeMainFacilitySelection> roomTypeMainFacilitySelections;
}
