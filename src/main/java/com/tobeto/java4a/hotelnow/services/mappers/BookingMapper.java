package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;

@Mapper
public interface BookingMapper {

	BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

	@Mapping(target = "hotelId", source = "hotel.id")
	ListBookingResponse listResponseFromBooking(Booking booking);

	List<ListBookingResponse> listResponsesFromBookings(List<Booking> bookings);

	@Mapping(target = "hotelId", source = "hotel.id")
	AddBookingResponse addResponseFromBooking(Booking booking);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "payment", ignore = true)
	@Mapping(target = "bookedAt", ignore = true)
	@Mapping(target = "review", ignore = true)
	@Mapping(target = "bookingHistories", ignore = true)
	@Mapping(target = "hotel.id", expression = "java(addBookingRequest.getHotelId())")
	@Mapping(target = "bookedRoomTypes", ignore = true)
	@Mapping(target = "customer", source = "customer")
	Booking bookingFromAddRequest(AddBookingRequest addBookingRequest, Customer customer);

}
