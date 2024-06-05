package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;

import java.util.List;

public interface DistrictService {

    List<ListDistrictResponse> getAll();
    List<ListDistrictResponse> getByCityId(int cityId);

}
