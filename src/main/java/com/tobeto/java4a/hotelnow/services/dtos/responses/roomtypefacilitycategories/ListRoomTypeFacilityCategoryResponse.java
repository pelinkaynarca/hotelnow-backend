package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories;

import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeFacilityCategoryResponse {

    private int id;
    private String title;
    private List<ListRoomTypeFacilityDetailOptionResponse> roomTypeFacilityOptionResponse;
}



