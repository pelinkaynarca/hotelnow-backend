package com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMainFacilitySelectionResponse {

    private int id;

    private boolean display;

    private int optionId;

    private int hotelId;
}
