package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.entities.concretes.HotelImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages.AddHotelImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.AddHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.hotelimages.ListHotelImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ImageDetailResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface HotelImageMapper {

    HotelImageMapper INSTANCE = Mappers.getMapper(HotelImageMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "imageName", source = "imageName")
    @Mapping(target = "path", source = "path")
    ListImageResponse listResponseFromImage(HotelImage hotelImage);

    @Mapping(target = "hotelId", source = "hotelImage.hotel.id")
    @Mapping(target = "photos", source = "imageResponses")
    ListHotelImageResponse listResponseByHotelId(HotelImage hotelImage, List<ListImageResponse> imageResponses);

    @Mappings({
            @Mapping(target = "imageName", source = "imageName"),
            @Mapping(target = "path", source = "pathOrContainerName"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "hotel", ignore = true)
    })
    HotelImage listResponseFromImageDetail(ImageDetailResponse imageDetail);

    @Mapping(target = "hotel", source = "hotel")
    HotelImage hotelImageFromAddRequest(AddHotelImageRequest request, Hotel hotel);

    @Mapping(target = "hotelId", source = "hotel.id")
    @Mapping(target = "photos", source = "savedImages")
    AddHotelImageResponse addResponseFromHotelImage(AddHotelImageRequest request, List<HotelImage> savedImages, Hotel hotel);

    List<ListImageResponse> listResponseFromImageResponses(List<HotelImage> hotelImages);

    default List<HotelImage> listHotelImages(List<ImageDetailResponse> imageDetails, HotelImage existingImage) {
        List<HotelImage> list = new ArrayList<>();
        for (ImageDetailResponse detail : imageDetails) {
            HotelImage newImage = listResponseFromImageDetail(detail);
            newImage.setHotel(existingImage.getHotel());
            list.add(newImage);
        }
        return list;
    }

}
