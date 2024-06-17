package com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages;

import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  AddHotelImageResponse {

    private int hotelId;

    private List<ListImageResponse> photos;

}
