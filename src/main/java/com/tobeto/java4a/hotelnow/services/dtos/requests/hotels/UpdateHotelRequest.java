package com.tobeto.java4a.hotelnow.services.dtos.requests.hotels;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHotelRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    private String address;

    @Nullable
    private Byte stars;

    @NotBlank
    private String description;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    @Min(value = 1)
    private int neighborhoodId;
}
