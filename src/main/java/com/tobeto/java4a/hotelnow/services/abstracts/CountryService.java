package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListOnlyCountryResponse;

import java.util.List;

public interface CountryService {

    List<ListOnlyCountryResponse> getAll();

    ListOnlyCountryResponse getOnlyCountryById(int countryId);
}
