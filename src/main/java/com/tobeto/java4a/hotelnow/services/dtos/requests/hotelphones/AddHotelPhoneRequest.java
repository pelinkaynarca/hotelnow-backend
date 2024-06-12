package com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddHotelPhoneRequest {

    @Pattern(regexp = "^[0-9]{11}$")
    private String phone;

}
