package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilityOption;
import com.tobeto.java4a.hotelnow.repositories.MainFacilityOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.AddMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.UpdateMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.AddMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.UpdateMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.MainFacilityOptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MainFacilityOptionServiceImpl implements MainFacilityOptionService {

    private MainFacilityOptionRepository mainFacilityOptionRepository;

    @Override
    public List<ListMainFacilityOptionResponse> getAll() {
        List<MainFacilityOption> mainFacilityOptions = mainFacilityOptionRepository.findAll();
        return mainFacilityOptions.stream().map(MainFacilityOptionMapper.INSTANCE::listResponseFromMainFacilityOption).collect(Collectors.toList());
    }

    @Override
    public MainFacilityOption getById(int id) {
        return mainFacilityOptionRepository.findById(id).orElse(null);
    }

    public ListMainFacilityOptionResponse getResponseById(int id) {
        MainFacilityOption mainFacilityOption = getById(id);
        return MainFacilityOptionMapper.INSTANCE.listResponseFromMainFacilityOption(mainFacilityOption);
    }

    @Override
    public AddMainFacilityOptionResponse add(AddMainFacilityOptionRequest request) {
        MainFacilityOption mainFacilityOption = MainFacilityOptionMapper.INSTANCE.mainFacilityOptionFromAddRequest(request);

        MainFacilityOption savedMainFacilityOption = mainFacilityOptionRepository.save(mainFacilityOption);

        return MainFacilityOptionMapper.INSTANCE.addResponseFromMainFacilityOption(savedMainFacilityOption);
    }

    @Override
    public UpdateMainFacilityOptionResponse update(UpdateMainFacilityOptionRequest request) {

        MainFacilityOption mainFacilityOption = MainFacilityOptionMapper.INSTANCE.mainFacilityOptionFromUpdateRequest(request);

        MainFacilityOption savedMainFacilityOption = mainFacilityOptionRepository.save(mainFacilityOption);

        return MainFacilityOptionMapper.INSTANCE.updateResponseFromMainFacilityOption(savedMainFacilityOption);
    }

    @Override
    public void deleteById(int id) {
        mainFacilityOptionRepository.deleteById(id);
    }
}
