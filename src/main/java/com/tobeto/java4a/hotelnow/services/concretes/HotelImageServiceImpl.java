package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.HotelImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.HotelImageService;
import com.tobeto.java4a.hotelnow.services.abstracts.ImageService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.mappers.HotelImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Service
public class HotelImageServiceImpl implements HotelImageService {

    private final HotelImageRepository hotelImageRepository;
    private final UserService userService;
    private final StaffService staffService;
    private final ImageService imageService;

    @Override
    public ListHotelImageResponse getByHotelId(int hotelId) {
        List<HotelImage> hotelImages = hotelImageRepository.findByHotelId(hotelId);
        List<ListImageResponse> imageResponses = HotelImageMapper.INSTANCE.listResponseFromImageResponses(hotelImages);

        return HotelImageMapper.INSTANCE.listResponseByHotelId(
                hotelImages.isEmpty() ? null : hotelImages.get(0), imageResponses);
    }

    @Override
    public List<ListImageResponse> getResponse(List<HotelImage> hotelImages) {
        return HotelImageMapper.INSTANCE.listResponseFromImageResponses(hotelImages);
    }

    @Override
    public AddHotelImageResponse add(AddHotelImageRequest request) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        HotelImage hotelImage = HotelImageMapper.INSTANCE.hotelImageFromAddRequest(request, staff.getHotel());

        List<MultipartFile> files = request.getFiles();
        CompletableFuture<List<ImageDetailResponse>> uploadResult = imageService.uploadImagesAsync("hotels", files);

        List<ImageDetailResponse> imageDetails = uploadResult.join();

        List<HotelImage> hotelImages = HotelImageMapper.INSTANCE.listHotelImages(imageDetails, hotelImage);

        List<HotelImage> savedImages = hotelImageRepository.saveAll(hotelImages);
        return HotelImageMapper.INSTANCE.addResponseFromHotelImage(request, savedImages, staff.getHotel());

    }

    @Override
    public void delete(int imageId) {
        imageService.delete(imageId);
    }

}
