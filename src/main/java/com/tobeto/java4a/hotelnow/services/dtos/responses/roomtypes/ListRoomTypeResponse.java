package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes;

import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.enums.Currency;

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

    private int size;

    private String bedTypeName;

    private String viewTypeName;

    private String description;

    private byte capacity;

    private boolean display;

    private Currency currency;

    private List<ListImageResponse> roomTypeImages;

    private List<ListRoomTypeFacilityDetailSelectionResponse> roomTypeFacilityDetailSelections;

    private List<ListRoomResponse> rooms;
}
