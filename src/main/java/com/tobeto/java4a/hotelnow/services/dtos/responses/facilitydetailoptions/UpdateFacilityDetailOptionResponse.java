package com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFacilityDetailOptionResponse {

    private int id;

    private String description;

    private String categoryTitle;

}
