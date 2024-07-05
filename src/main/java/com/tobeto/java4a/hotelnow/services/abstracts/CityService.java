package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListOnlyCityResponse;

import java.util.List;

public interface CityService {

    List<ListOnlyCityResponse> getAll();

    List<ListOnlyCityResponse> getOnlyCitiesByCountryId(int countryId);

    ListOnlyCityResponse getById(int id);
}
