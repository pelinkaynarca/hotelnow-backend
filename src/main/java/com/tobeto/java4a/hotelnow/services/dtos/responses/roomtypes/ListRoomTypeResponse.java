package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailSelection;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
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
public class ListRoomTypeResponse {

    private int id;

    private String name;

    private double pricePerNight;

    private String description;

    private byte capacity;

    private boolean display;

    private Currency currency;

    private List<RoomTypeImage> roomTypeImages;

    private List<RoomTypeFacilityDetailSelection> roomTypeMainFacilityDetailSelections;

    private List<RoomTypeMainFacilitySelection> roomTypeMainFacilitySelections;

    private List<Room> rooms;
}
