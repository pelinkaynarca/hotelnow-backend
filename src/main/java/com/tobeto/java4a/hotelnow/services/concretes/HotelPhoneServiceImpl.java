package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.*;
import com.tobeto.java4a.hotelnow.repositories.HotelPhoneRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelPhoneService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.AddHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelphones.UpdateHotelPhoneRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.AddHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.ListHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelphones.UpdateHotelPhoneResponse;
import com.tobeto.java4a.hotelnow.services.mappers.HotelPhoneMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HotelPhoneServiceImpl implements HotelPhoneService {

    private final HotelPhoneRepository hotelPhoneRepository;
    private final UserService userService;
    private final StaffService staffService;


    @Override
    public ListHotelPhoneResponse getResponseById(int id) {
        HotelPhone hotelPhone = hotelPhoneRepository.findById(id).orElseThrow();
        return HotelPhoneMapper.INSTANCE.listResponseFromHotelPhone(hotelPhone);
    }

    @Override
    public List<ListHotelPhoneResponse> getByHotelId(int hotelId) {
        List<HotelPhone> hotelPhones = hotelPhoneRepository.findByHotelId(hotelId);
        return hotelPhones.stream()
                .map(HotelPhoneMapper.INSTANCE::listResponseFromHotelPhone)
                .collect(Collectors.toList());
    }

    @Override
    public AddHotelPhoneResponse add(AddHotelPhoneRequest request) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        HotelPhone hotelPhone = HotelPhoneMapper.INSTANCE.hotelPhoneFromAddRequest(request, staff.getHotel());
        HotelPhone savedHotelPhone = hotelPhoneRepository.save(hotelPhone);
        return HotelPhoneMapper.INSTANCE.addResponseFromHotelPhone(savedHotelPhone);

    }

    @Override
    public UpdateHotelPhoneResponse update(UpdateHotelPhoneRequest request) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        HotelPhone hotelPhone = HotelPhoneMapper.INSTANCE.hotelPhoneFromUpdateRequest(request, staff.getHotel());
        HotelPhone savedHotelPhone = hotelPhoneRepository.save(hotelPhone);
        return HotelPhoneMapper.INSTANCE.updateResponseFromHotelPhone(savedHotelPhone);

    }

    @Override
    public void delete(int id) {
        hotelPhoneRepository.deleteById(id);
    }
}
