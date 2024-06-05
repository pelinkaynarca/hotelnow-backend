package com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListMainFacilitySelectionResponse {
    private boolean display;

    private String hotelName;

    private String mainFacilityOptionTitle;
}
