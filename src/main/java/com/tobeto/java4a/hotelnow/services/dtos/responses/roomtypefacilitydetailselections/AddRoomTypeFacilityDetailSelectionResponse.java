package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomTypeFacilityDetailSelectionResponse {

    private int id;

    private int roomTypeId;

    private int optionId;

    private boolean display;
}
