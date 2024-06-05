package com.tobeto.java4a.hotelnow.services.dtos.responses.cities;

import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCityResponse {

    private int id;

    private String name;

    private List<ListDistrictResponse> district;

}
