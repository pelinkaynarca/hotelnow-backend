package com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes;

import com.tobeto.java4a.hotelnow.services.enums.Currency;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomTypeRequest {

    @NotBlank
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    private double pricePerNight;

    @Min(value = 1)
    private int size;

    @NotNull
    private int bedTypeId;

    @NotNull
    private int viewTypeId;

    @NotBlank
    private String description;

    @Positive
    private byte capacity;

    private boolean display;

    @NotNull
    private Currency currency;

}
