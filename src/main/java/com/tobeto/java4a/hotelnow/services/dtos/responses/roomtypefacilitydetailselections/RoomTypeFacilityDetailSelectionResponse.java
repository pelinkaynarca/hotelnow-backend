package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeFacilityDetailSelectionResponse {

    private int id;

    private String optionDescription;

    private boolean display;

}
