package com.tobeto.java4a.hotelnow.services.dtos.responses.hotels;

import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListHotelResponse {
    private int id;

    private String name;

    private Byte stars;

    private String address;

    private String description;

    private String checkInTime;

    private String checkOutTime;

    private String neighborhoodName;

    private List<ListHotelPhoneResponse> hotelPhones;

    private List<ListHotelImageResponse> hotelImages;
}
