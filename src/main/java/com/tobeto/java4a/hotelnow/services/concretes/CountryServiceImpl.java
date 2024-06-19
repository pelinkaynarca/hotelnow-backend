package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.Country;
import com.tobeto.java4a.hotelnow.repositories.CountryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CountryService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListOnlyCountryResponse;
import com.tobeto.java4a.hotelnow.services.mappers.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Override
    public List<ListOnlyCountryResponse> getAll() {
        List<Country> countries = countryRepository.findAll();
        return CountryMapper.INSTANCE.listOnlyResponsesFromCountries(countries);
    }

    @Override
    public ListOnlyCountryResponse getOnlyCountryById(int id) {
        Country country = countryRepository.findById(id).orElse(null);
        return CountryMapper.INSTANCE.listOnlyResponseFromCountry(country);
    }
}