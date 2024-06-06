package com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHotelPhoneRequest {

    @Min(value = 1)
    private int id;

    @Pattern(regexp = "^$|[0-9]{10}")
    private String phone;

}
