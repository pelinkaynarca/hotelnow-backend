package com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListHotelPhoneResponse {

    private int id;

    private String phone;

    private String hotelName;

}
