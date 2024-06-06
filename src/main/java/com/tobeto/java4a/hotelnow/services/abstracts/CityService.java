package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListCityResponse;

import java.util.List;

public interface CityService {

    List<ListCityResponse> getAll();

    List<ListCityResponse> getByCountryId(int countryId);
}
