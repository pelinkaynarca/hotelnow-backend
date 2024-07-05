package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.District;
import com.tobeto.java4a.hotelnow.repositories.DistrictRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.DistrictService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListOnlyDistrictResponse;
import com.tobeto.java4a.hotelnow.services.mappers.DistrictMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Override
    public List<ListOnlyDistrictResponse> getAll() {
        List<District> districts = districtRepository.findAll();
        return DistrictMapper.INSTANCE.listOnlyResponsesFromDistricts(districts);
    }

    /* @Override
    public List<ListDistrictResponse> getByCityId(int cityId) {
        return districtRepository.findByCityId(cityId).stream()
                .map(district -> DistrictMapper.INSTANCE.listResponseFromDistrict(
                        district,
                        DistrictMapper.INSTANCE.mapNeighborhoodsToListNeighborhoodResponses(district.getNeighborhoods())
                ))
                .collect(Collectors.toList());
    } */

    @Override
    public ListDistrictResponse getById(int id) {
        District district = districtRepository.findById(id).orElse(null);
        return DistrictMapper.INSTANCE.listResponseFromDistrict(district);
    }

    @Override
    public List<ListOnlyDistrictResponse> getOnlyDistrictsByCityId(int cityId) {
        List<District> districts = districtRepository.findByCityId(cityId);
        return DistrictMapper.INSTANCE.listOnlyResponsesFromDistricts(districts);
    }
}
