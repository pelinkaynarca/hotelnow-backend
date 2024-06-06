package com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFacilityDetailSelectionResponse {

	private int id;

	private int hotelId;

	private int optionId;

	private boolean display;

}
