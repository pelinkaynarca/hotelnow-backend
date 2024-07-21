package com.tobeto.java4a.hotelnow.services.rules;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.enums.BookingStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingRules {
	
	private final BookingService bookingService;
	private final RoomService roomService;
	
	// TODO business rule availableRoomsShouldExistBetweenCheckInAndCheckOutDates
	public void availableRoomsShouldExistBetweenCheckInAndCheckOutDates(AddBookingRequest request) {
		LocalDate checkInDate = request.getCheckInDate(), checkOutDate = request.getCheckOutDate();

		List<Booking> approvedBookingsOfHotel = bookingService.getBookingsOfHotelByStatus(BookingStatus.APPR);
		List<List<BookedRoomType>> bookedRoomTypesPerBooking = approvedBookingsOfHotel.stream()
				.map(b -> b.getBookedRoomTypes()).toList();
		List<BookedRoomType> bookedRoomTypes = new ArrayList<BookedRoomType>();
		bookedRoomTypesPerBooking.stream()
				.forEach(bookedRoomTypesOfBooking -> bookedRoomTypes.addAll(bookedRoomTypesOfBooking));
		List<Pair<Integer, Integer>> totalBookedRoomCountsPerRoomType = new ArrayList<Pair<Integer, Integer>>();

		bookedRoomTypes.forEach((brt) -> {
			int indexOfBookedRoomType = getIndexOfBookedRoomType(totalBookedRoomCountsPerRoomType,
					brt.getRoomType().getId());
			if (indexOfBookedRoomType == -1) {
				totalBookedRoomCountsPerRoomType.add(Pair.with(brt.getRoomType().getId(), brt.getRoomCount()));
			} else {
				Pair<Integer, Integer> totalBookedRoomCountOfRoomtype = totalBookedRoomCountsPerRoomType
						.get(indexOfBookedRoomType);
				totalBookedRoomCountOfRoomtype.setAt1(totalBookedRoomCountOfRoomtype.getValue1() + brt.getRoomCount());
			}
		});

		totalBookedRoomCountsPerRoomType.forEach((tbrc) -> {
			List<Room> allRoomsOfRoomType = roomService.getByRoomTypeId(tbrc.getValue0());
			List<Room> availableRoomsOfRoomType = allRoomsOfRoomType.stream().filter(r -> r.isAvailable()).toList();
			int totalAvailableRoomsOfRoomType = availableRoomsOfRoomType.size();
			if (tbrc.getValue1() >= totalAvailableRoomsOfRoomType) {
				throw new BusinessException(Messages.Error.CUSTOM_NO_ROOM_AVAILABLE_FOR_GIVEN_DATES);
			}
		});
	}
	
	private int getIndexOfBookedRoomType(List<Pair<Integer, Integer>> pairs, int roomTypeId) {
		int index = -1, indexCount = 0;
		for (Pair<Integer, Integer> pair : pairs) {
			if (pair.getValue0() == roomTypeId) {
				index = indexCount;
				return index;
			}
			indexCount++;
		}
		return index;
	}
	
}
