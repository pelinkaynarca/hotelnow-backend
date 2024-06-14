package com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomTypeMainFacilitySelectionRequest {

    @Min(value = 1)
    private int roomTypeId;

    @Min(value = 1)
    private int optionId;

    private boolean display;
}
