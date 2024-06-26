package com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories;

import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListFacilityCategoryResponse {

    private int id;

    private String title;

    private List<ListFacilityDetailOptionResponse> FacilityDetailOptionResponse;
}
