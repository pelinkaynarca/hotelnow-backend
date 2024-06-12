package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.*;
import com.tobeto.java4a.hotelnow.repositories.HotelRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelService;
import com.tobeto.java4a.hotelnow.services.abstracts.NeighborhoodService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import com.tobeto.java4a.hotelnow.services.mappers.HotelMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final NeighborhoodService neighborhoodService;
    private final UserService userService;
    private final StaffService staffService;

    @Override
    public List<ListHotelResponse> getAll() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper.INSTANCE::listResponseFromHotel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListHotelResponse> getByNeighborhoodId(int neighborhoodId) {
        return hotelRepository.findByNeighborhoodId(neighborhoodId).stream()
                .map(HotelMapper.INSTANCE::listResponseFromHotel)
                .collect(Collectors.toList());
    }

    @Override
    public Hotel getById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public List<ListHotelResponse> getByActive(boolean active) {
        return hotelRepository.findByActive(active).stream()
                .map(HotelMapper.INSTANCE::listResponseFromHotel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListHotelResponse> getByStars(Byte stars) {
        return hotelRepository.findByStars(stars).stream()
                .map(HotelMapper.INSTANCE::listResponseFromHotel)
                .collect(Collectors.toList());
    }

    @Override
    public ListHotelResponse getResponseById(int id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return HotelMapper.INSTANCE.listResponseFromHotel(hotel);
    }

    @Override
    public AddHotelResponse add(AddHotelRequest request) {

        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(request);

        Neighborhood neighborhood = neighborhoodService.getById(request.getNeighborhoodId());
        hotel.setNeighborhood(neighborhood);

        Hotel savedHotel = hotelRepository.save(hotel);

        return HotelMapper.INSTANCE.addResponseFromHotel(savedHotel);

    }

    @Override
    public UpdateHotelResponse update(UpdateHotelRequest request) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        int hotelId = staff.getHotel().getId();

        Hotel hotel = HotelMapper.INSTANCE.hotelFromUpdateRequest(request);

        hotel.setId(hotelId);

        Hotel savedHotel = hotelRepository.save(hotel);

        return HotelMapper.INSTANCE.updateResponseFromHotel(savedHotel);

    }

}
