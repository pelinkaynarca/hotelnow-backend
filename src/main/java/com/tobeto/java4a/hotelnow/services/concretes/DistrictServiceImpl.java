package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.DistrictRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.DistrictService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService {

    private DistrictRepository districtRepository;

    @Override
    public List<ListDistrictResponse> getAll() {
        return List.of();
    }

    @Override
    public List<ListDistrictResponse> getByCityId(int cityId) {
        return List.of();
    }
}
