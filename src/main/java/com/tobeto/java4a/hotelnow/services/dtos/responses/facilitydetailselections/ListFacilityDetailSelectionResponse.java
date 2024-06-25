package com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListFacilityDetailSelectionResponse {

	private int hotelId;

	private String categoryName;

	private List<FacilityDetailSelectionResponse> facilityDetailSelection;

}
