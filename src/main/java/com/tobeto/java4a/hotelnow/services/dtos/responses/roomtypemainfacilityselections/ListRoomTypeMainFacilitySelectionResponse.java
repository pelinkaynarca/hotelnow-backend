package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeMainFacilitySelectionResponse {

    private int id;

    private int roomTypeId;

    private String optionTitle;

    private boolean display;
}
