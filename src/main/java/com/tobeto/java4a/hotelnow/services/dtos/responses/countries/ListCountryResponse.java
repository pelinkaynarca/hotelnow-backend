package com.tobeto.java4a.hotelnow.services.dtos.responses.countries;

import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListCityResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCountryResponse {

    private int id;

    private String name;

    private List<ListCityResponse> city;

}
