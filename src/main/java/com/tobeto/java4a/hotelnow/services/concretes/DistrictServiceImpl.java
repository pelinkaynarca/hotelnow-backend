package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.DistrictRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.DistrictService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import com.tobeto.java4a.hotelnow.services.mappers.DistrictMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Override
    public List<ListDistrictResponse> getAll() {
        return districtRepository.findAll().stream()
                .map(district -> DistrictMapper.INSTANCE.listResponseFromDistrict(
                        district,
                        DistrictMapper.INSTANCE.mapNeighborhoodsToListNeighborhoodResponses(district.getNeighborhoods())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<ListDistrictResponse> getByCityId(int cityId) {
        return districtRepository.findByCityId(cityId).stream()
                .map(district -> DistrictMapper.INSTANCE.listResponseFromDistrict(
                        district,
                        DistrictMapper.INSTANCE.mapNeighborhoodsToListNeighborhoodResponses(district.getNeighborhoods())
                ))
                .collect(Collectors.toList());
    }
}
