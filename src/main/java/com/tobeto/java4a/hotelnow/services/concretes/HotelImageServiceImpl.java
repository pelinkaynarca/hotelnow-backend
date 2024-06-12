package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.HotelImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelImageService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.mappers.HotelImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HotelImageServiceImpl implements HotelImageService {

    private final HotelImageRepository hotelImageRepository;
    private final UserService userService;
    private final StaffService staffService;

    @Override
    public List<ListHotelImageResponse> getByHotelId(int hotelId) {
        List<HotelImage> hotelImages = hotelImageRepository.findByHotelId(hotelId);
        return hotelImages.stream()
                .map(HotelImageMapper.INSTANCE::listResponseFromHotelImage)
                .collect(Collectors.toList());
    }

    @Override
    public ListHotelImageResponse getById(int id) {

        HotelImage hotelImage = hotelImageRepository.findById(id).orElse(null);
        return HotelImageMapper.INSTANCE.listResponseFromHotelImage(hotelImage);

    }

    @Override
    public AddHotelImageResponse add(AddHotelImageRequest request) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        HotelImage hotelImage = HotelImageMapper.INSTANCE.hotelImageFromAddRequest(request, staff.getHotel());
        HotelImage savedHotelImage = hotelImageRepository.save(hotelImage);
        return HotelImageMapper.INSTANCE.addResponseFromHotelImage(savedHotelImage);

    }

    @Override
    public void delete(int id) {
        hotelImageRepository.deleteById(id);
    }

}
