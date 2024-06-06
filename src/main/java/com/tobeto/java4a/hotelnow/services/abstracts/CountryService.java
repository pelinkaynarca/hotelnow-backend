package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListCountryResponse;

import java.util.List;

public interface CountryService {

    List<ListCountryResponse> getAll();
}
