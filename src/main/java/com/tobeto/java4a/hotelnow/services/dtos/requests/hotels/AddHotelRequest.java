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
public class AddHotelRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Min(1)
    @Max(5)
    private byte stars;

}
