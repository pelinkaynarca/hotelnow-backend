package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeMainFacilityOptionResponse {

    private int id;

    private String title;

    private List<ListRoomTypeMainFacilityOptionResponse> roomTypeMainFacilitySelectionResponse;

}
