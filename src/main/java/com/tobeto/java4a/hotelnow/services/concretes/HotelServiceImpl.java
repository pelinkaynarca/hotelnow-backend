package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.*;
import com.tobeto.java4a.hotelnow.repositories.HotelRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.*;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.AddHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotels.UpdateHotelRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.AddHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.ListHotelResponseForStaff;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotels.UpdateHotelResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.reviews.ListReviewResponseByHotelId;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
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
    private final ReviewService reviewService;
    private final RoomTypeService roomTypeService;
    private final MainFacilitySelectionService mainFacilitySelectionService;
    private final FacilityDetailSelectionService facilityDetailSelectionService;

    private ListHotelResponse mapHotelToListHotelResponse(Hotel hotel) {
        List<ListReviewResponseByHotelId> reviews = reviewService.getByHotelId(hotel.getId());
        List<ListRoomTypeResponse> roomTypes = roomTypeService.getByHotelId(hotel.getId());
        List<ListMainFacilitySelectionResponse> mainFacilitySelections = mainFacilitySelectionService.getByHotelId(hotel.getId());
        List<ListFacilityDetailSelectionResponse> facilityDetailSelections = facilityDetailSelectionService.getResponseByHotelId(hotel.getId());
        return HotelMapper.INSTANCE.listResponseFromHotel(hotel, reviews, roomTypes, mainFacilitySelections, facilityDetailSelections);
    }

    @Override
    public List<ListHotelResponse> getAll() {
        return hotelRepository.findAll().stream()
                .map(this::mapHotelToListHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListHotelResponse> getByNeighborhoodId(int neighborhoodId) {
        return hotelRepository.findByNeighborhoodId(neighborhoodId).stream()
                .map(this::mapHotelToListHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Hotel getById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public List<ListHotelResponse> getByActive(boolean active) {
        return hotelRepository.findByActive(active).stream()
                .map(this::mapHotelToListHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListHotelResponse> getByStars(byte stars) {
        return hotelRepository.findByStars(stars).stream()
                .map(this::mapHotelToListHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListHotelResponse> getByStarsGreaterThanEqual() {
        byte minStars = 4;
        return hotelRepository.findByStarsGreaterThanEqual(minStars).stream()
                .map(this::mapHotelToListHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListHotelResponse> getByFilter(Integer cityId, Byte capacity, Byte stars) {
        return hotelRepository.findByFilter(cityId, capacity, stars).stream()
                .map(this::mapHotelToListHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ListHotelResponse getResponseById(int id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return null;
        }
        return mapHotelToListHotelResponse(hotel);
    }

    @Override
    public ListHotelResponseForStaff getResponseForStaff() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());

        return HotelMapper.INSTANCE.listResponseForStaffFromHotel(staff.getHotel());
    }

    @Override
    public AddHotelResponse add(AddHotelRequest request) {

        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(request);

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
