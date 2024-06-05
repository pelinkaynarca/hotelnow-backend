package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeFacilityDetailSelectionResponse {

    private int id;

    private String roomTypeName;

    private String optionName;

    private boolean display;
}
