package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.RoomTypeMainFacilitySelectionResponse;
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

    private List<ListImageResponse> roomTypeImages;

    private List<ListRoomTypeFacilityDetailSelectionResponse> roomTypeFacilityDetailSelections;

    private List<RoomTypeMainFacilitySelectionResponse> roomTypeMainFacilitySelections;

    private List<ListRoomResponse> rooms;
}
