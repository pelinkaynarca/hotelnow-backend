package com.tobeto.java4a.hotelnow.services.dtos.responses.hotels;

import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponseByHotelId;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
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

    private byte stars;

    private String address;

    private String description;

    private boolean active;

    private String checkInTime;

    private String checkOutTime;

    private String neighborhoodName;

    private List<ListMainFacilitySelectionResponse> mainFacilitySelections;

    private List<ListFacilityDetailSelectionResponse> facilityDetailSelections;

    private List<ListHotelPhoneResponse> hotelPhones;

    private List<ListImageResponse> hotelImages;

    private List<ListRoomTypeResponse> roomTypes;

    private List<ListReviewResponseByHotelId> reviews;


}
