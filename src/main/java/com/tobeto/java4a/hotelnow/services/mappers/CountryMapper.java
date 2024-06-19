package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Country;
import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListOnlyCountryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    List<ListOnlyCountryResponse> listOnlyResponsesFromCountries(List<Country> countries);

    ListOnlyCountryResponse listOnlyResponseFromCountry(Country country);
}
