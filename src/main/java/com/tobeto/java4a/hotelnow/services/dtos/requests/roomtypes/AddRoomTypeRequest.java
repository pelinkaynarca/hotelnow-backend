package com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes;

import com.tobeto.java4a.hotelnow.core.enums.Currency;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomTypeRequest {

    @NotBlank
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    private double pricePerNight;

    @NotBlank
    private String description;

    @Positive
    private byte capacity;

    private boolean display;

    private Currency currency;

    List<RoomTypeMainFacilitySelection> roomTypeMainFacilitySelections;
}
