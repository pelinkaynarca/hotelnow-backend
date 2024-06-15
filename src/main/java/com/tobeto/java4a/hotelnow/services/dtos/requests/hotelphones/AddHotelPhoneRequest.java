package com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddHotelPhoneRequest {

    @Pattern(regexp = "^[0-9]{11}$")
    @NotBlank
    private String phone;

}
