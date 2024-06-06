package com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections;

import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListFacilityDetailSelectionResponse {
	
	private int id;

	private int hotelId;

	private ListFacilityDetailOptionResponse option;

	private boolean display;

}
