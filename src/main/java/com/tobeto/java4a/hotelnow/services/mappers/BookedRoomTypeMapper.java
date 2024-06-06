package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.UpdateBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.AddBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.ListBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.UpdateBookedRoomTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookedRoomTypeMapper {

    BookedRoomTypeMapper  INSTANCE = Mappers.getMapper(BookedRoomTypeMapper.class);

    @Mapping(target = "bookingHotelName", source = "booking.hotel.name")
    @Mapping(target = "roomTypeName", source = "roomType.name")
    ListBookedRoomTypeResponse listResponseFromBookedRoomType(BookedRoomType bookedRoomType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "roomType.id", source = "roomTypeId")
    BookedRoomType bookedRoomTypeFromAddRequest(AddBookedRoomTypeRequest request);

    @Mapping(target = "bookingId", source = "booking.id")
    @Mapping(target = "roomTypeId", source = "roomType.id")
    AddBookedRoomTypeResponse addResponseFromBookedRoomType(BookedRoomType bookedRoomType);

    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "roomType.id", source = "roomTypeId")
    BookedRoomType bookedRoomTypeFromUpdateRequest(UpdateBookedRoomTypeRequest request);

    @Mapping(target = "bookingId", source = "booking.id")
    @Mapping(target = "roomTypeId", source = "roomType.id")
    UpdateBookedRoomTypeResponse updateResponseFromBookedRoomType(BookedRoomType bookedRoomType);
}
