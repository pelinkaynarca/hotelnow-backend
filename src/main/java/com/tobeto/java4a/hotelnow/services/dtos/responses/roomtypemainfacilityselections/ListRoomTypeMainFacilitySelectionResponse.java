package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeMainFacilitySelectionResponse {

    private int roomTypeId;

    private List<RoomTypeMainFacilitySelectionResponse> roomTypeMainFacilitySelectionResponses;
}
