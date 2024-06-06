package com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListHotelImageResponse {

    private int id;

    private String url;

    private String hotelName;

}
