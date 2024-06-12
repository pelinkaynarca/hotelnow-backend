package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.*;
import com.tobeto.java4a.hotelnow.repositories.MainFacilitySelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.UpdateMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.UpdateMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.MainFacilitySelectionMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MainFacilitySelectionServiceImpl implements MainFacilitySelectionService {

    private final MainFacilitySelectionRepository mainFacilitySelectionRepository;
    private final UserService userService;
    private final StaffService staffService;

    @Override
    public List<ListMainFacilitySelectionResponse> getByHotelId(int hotelId) {
        List<MainFacilitySelection> mainFacilitySelections = mainFacilitySelectionRepository.findByHotelId(hotelId);
        return mainFacilitySelections.stream()
                .map(MainFacilitySelectionMapper.INSTANCE::listResponseFromMainFacilitySelection)
                .collect(Collectors.toList());
    }

    @Override
    public AddMainFacilitySelectionResponse add(AddMainFacilitySelectionRequest request) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        MainFacilitySelection mainFacilitySelection = MainFacilitySelectionMapper.INSTANCE.mainFacilitySelectionFromAddRequest(request, staff.getHotel());
        MainFacilitySelection savedMainFacilitySelection = mainFacilitySelectionRepository.save(mainFacilitySelection);
        return MainFacilitySelectionMapper.INSTANCE.addResponseFromMainFacilitySelection(savedMainFacilitySelection);

    }

    @Override
    public UpdateMainFacilitySelectionResponse update(UpdateMainFacilitySelectionRequest request) {

        //TODO: check again. optionId returns null
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        MainFacilitySelection mainFacilitySelection = MainFacilitySelectionMapper.INSTANCE.mainFacilitySelectionFromUpdateRequest(request, staff.getHotel());
        MainFacilitySelection savedMainFacilitySelection = mainFacilitySelectionRepository.save(mainFacilitySelection);
        return MainFacilitySelectionMapper.INSTANCE.updateResponseFromMainFacilitySelection(savedMainFacilitySelection);

    }

}
