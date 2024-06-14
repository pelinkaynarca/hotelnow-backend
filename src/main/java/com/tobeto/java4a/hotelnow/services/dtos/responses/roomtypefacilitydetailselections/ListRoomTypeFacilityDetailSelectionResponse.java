package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeFacilityDetailSelectionResponse {

    private int roomTypeId;

    private String categoryName;

    private List<RoomTypeFacilityDetailSelectionResponse> roomTypeFacilityDetailSelectionResponses;
}
