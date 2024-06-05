package com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddHotelImageRequest {

    @NotBlank
    private String url;

}
