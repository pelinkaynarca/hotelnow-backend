package com.tobeto.java4a.hotelnow.services.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.javatuples.Pair;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.enums.BookingStatus;
import com.tobeto.java4a.hotelnow.core.enums.PaymentStatus;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.entities.concretes.BookingHistory;
import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Payment;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.BookingRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookedRoomTypeService;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingHistoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.abstracts.PaymentService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;
import com.tobeto.java4a.hotelnow.services.mappers.BookedRoomTypeMapper;
import com.tobeto.java4a.hotelnow.services.mappers.BookingMapper;
import com.tobeto.java4a.hotelnow.services.mappers.PaymentMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;
	private final BookingHistoryService bookingHistoryService;
	private final BookedRoomTypeService bookedRoomTypeService;
	private final UserService userService;
	private final CustomerService customerService;
	private final StaffService staffService;
	private final PaymentService paymentService;
//	private final RoomTypeService roomTypeService;
	private final RoomService roomService;

	@Override
	public Booking getById(int id) {
		Booking booking = bookingRepository.findById(id).orElseThrow();
		return booking;
	}

	@Override
	public ListBookingResponse getResponseById(int id) {
		Booking booking = bookingRepository.findById(id).orElseThrow();
		return BookingMapper.INSTANCE.listResponseFromBooking(booking);
	}

	@Override
	public List<ListBookingResponse> getByCustomerId(int customerId) {
		List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
		return BookingMapper.INSTANCE.listResponsesFromBookings(bookings);
	}

	@Override
	public List<ListBookingResponse> getByHotelId(int hotelId) {
		List<Booking> bookings = bookingRepository.findByHotelId(hotelId);
		return BookingMapper.INSTANCE.listResponsesFromBookings(bookings);
	}
	
	@Override
	public List<ListBookingResponse> getPendings() {
		loggedInUserMustBeManager();
		List<Booking> pendingBookingsOfHotel = getByStatus(BookingStatus.PEND);
		return BookingMapper.INSTANCE.listResponsesFromBookings(pendingBookingsOfHotel);
	}
	
	@Override
	public List<ListBookingResponse> getApproveds() {
		loggedInUserMustBeManager();
		List<Booking> pendingBookingsOfHotel = getByStatus(BookingStatus.APPR);
		return BookingMapper.INSTANCE.listResponsesFromBookings(pendingBookingsOfHotel);
	}
	
	@Override
	public List<ListBookingResponse> getCancelleds() {
		loggedInUserMustBeManager();
		List<Booking> pendingBookingsOfHotel = getByStatus(BookingStatus.CANC);
		return BookingMapper.INSTANCE.listResponsesFromBookings(pendingBookingsOfHotel);
	}

	@Override
	public AddBookingResponse add(AddBookingRequest request) {
//		availableRoomsShouldExistBetweenCheckInAndCheckOutDates(request);
		// Get logged in user
		User loggedInUser = getLoggedInUser();
		Customer customer = customerService.getById(loggedInUser.getId());

		// Save booking
		Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request, customer);
		Booking savedBooking = bookingRepository.save(booking);

		// Save booked room types
		List<AddBookedRoomTypeRequest> addBookedRoomTypeRequests = request.getBookedRoomTypes();
		List<BookedRoomType> bookedRoomTypes = BookedRoomTypeMapper.INSTANCE
				.bookedRoomTypesFromAddRequests(addBookedRoomTypeRequests);
		bookedRoomTypes.stream().forEach((brt) -> brt.setBooking(savedBooking));
		List<BookedRoomType> savedBookedRoomTypes = bookedRoomTypeService.addAll(bookedRoomTypes);
		savedBooking.setBookedRoomTypes(savedBookedRoomTypes);

		// Save payment info
		AddPaymentRequest addPaymentRequest = request.getPayment();
		addPaymentRequest.setPaymentStatus(PaymentStatus.WITHDRAW);
		addPaymentRequest.setBookingId(savedBooking.getId());
		Payment savedPayment = paymentService
				.addPayment(PaymentMapper.INSTANCE.paymentFromAddRequest(addPaymentRequest));
		savedBooking.setPayment(savedPayment);

		// Save the first booking history info
		BookingHistory bookingHistory = new BookingHistory();
		bookingHistory.setUser(loggedInUser);
		bookingHistory.setBooking(savedBooking);
		bookingHistory.setStatus(BookingStatus.PEND);
		List<BookingHistory> bookingHistories = List.of(bookingHistoryService.addBookingHistory(bookingHistory));
		savedBooking.setBookingHistories(bookingHistories);

		return BookingMapper.INSTANCE.addResponseFromBooking(savedBooking);
	}

	@Override
	public void approve(int bookingId) {
		loggedInUserMustBeManager();

		Booking booking = getById(bookingId);
		List<BookingHistory> bookingHistories = booking.getBookingHistories();
		// Sort booking histories by date
		Collections.sort(bookingHistories, (bh1, bh2) -> {
			long millis1 = bh1.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
			long millis2 = bh2.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
			return millis1 <= millis2 ? -1 : 1;
		});
		if (bookingHistories.get(bookingHistories.size() - 1).getStatus() == BookingStatus.PEND) {
			BookingHistory bookingHistory = new BookingHistory();
			bookingHistory.setBooking(booking);
			bookingHistory.setUser(getLoggedInUser());
			bookingHistory.setEditedAt(LocalDateTime.now());
			bookingHistory.setStatus(BookingStatus.APPR);
			booking.getBookingHistories().add(bookingHistory);
			bookingRepository.save(booking);
		}
	}
	
	@Override
	public void cancel(int bookingId) {
		loggedInUserMustBeManager();

		Booking booking = getById(bookingId);
		List<BookingHistory> bookingHistories = booking.getBookingHistories();
		// Sort booking histories by date
		Collections.sort(bookingHistories, (bh1, bh2) -> {
			long millis1 = bh1.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
			long millis2 = bh2.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
			return millis1 <= millis2 ? -1 : 1;
		});
		if (bookingHistories.get(bookingHistories.size() - 1).getStatus() == BookingStatus.PEND) {
			BookingHistory bookingHistory = new BookingHistory();
			bookingHistory.setBooking(booking);
			bookingHistory.setUser(getLoggedInUser());
			bookingHistory.setEditedAt(LocalDateTime.now());
			bookingHistory.setStatus(BookingStatus.CANC);
			booking.getBookingHistories().add(bookingHistory);
			bookingRepository.save(booking);
		}
	}
	
	private List<Booking> getByStatus(BookingStatus bookingStatus) {
		Staff loggedInStaff = staffService.getLoggedInStaff();
		List<Booking> allBookingsOfHotel = bookingRepository.findByHotelId(loggedInStaff.getHotel().getId());
		List<Booking> filteredBookingsOfHotelByStatus = allBookingsOfHotel.stream().filter((b) -> {
			List<BookingHistory> bookingHistories = b.getBookingHistories();
			Collections.sort(bookingHistories, (bh1, bh2) -> {
				long millis1 = bh1.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				long millis2 = bh2.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				return millis1 <= millis2 ? -1 : 1;
			});
			return bookingHistories.get(bookingHistories.size() - 1).getStatus() == bookingStatus;
		}).toList();

		// sort bookings in chronological descending order
		filteredBookingsOfHotelByStatus.stream().sorted((b1, b2) -> {
			List<BookingHistory> bookingHistories1 = b1.getBookingHistories();
			Collections.sort(bookingHistories1, (bh1, bh2) -> {
				long millis1 = bh1.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				long millis2 = bh2.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				return millis1 <= millis2 ? -1 : 1;
			});
			List<BookingHistory> bookingHistories2 = b2.getBookingHistories();
			Collections.sort(bookingHistories2, (bh1, bh2) -> {
				long millis1 = bh1.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				long millis2 = bh2.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				return millis1 <= millis2 ? -1 : 1;
			});
			BookingHistory lastBookingHistory1 = bookingHistories1.get(bookingHistories1.size() - 1);
			BookingHistory lastBookingHistory2 = bookingHistories2.get(bookingHistories2.size() - 1);
			return lastBookingHistory1.getEditedAt().isBefore(lastBookingHistory2.getEditedAt()) ? -1 : 1;
		}).toList();

		return filteredBookingsOfHotelByStatus;
	}
	
	private void loggedInUserMustBeManager() {
		User user = getLoggedInUser();
		if (!user.getAuthorities().contains(Role.MANAGER)) {
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
		}
	}

	private User getLoggedInUser() {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(email);
		return loggedInUser;
	}
	
	//TODO business rule availableRoomsShouldExistBetweenCheckInAndCheckOutDates
	private void availableRoomsShouldExistBetweenCheckInAndCheckOutDates(AddBookingRequest request) {
		LocalDate checkInDate = request.getCheckInDate(), checkOutDate = request.getCheckOutDate();

		List<Booking> allBookingsOfHotel = bookingRepository.findAllBookingsOfHotelBetweenDates(
				request.getHotelId(), checkInDate, checkOutDate);
		List<Booking> approvedBookingsOfHotel = allBookingsOfHotel.stream().filter((b) -> {
			boolean isApprovedOrPending = false;
			List<BookingHistory> bookingHistories = b.getBookingHistories();
			Collections.sort(bookingHistories, (bh1, bh2) -> {
				long millis1 = bh1.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				long millis2 = bh2.getEditedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				return millis1 <= millis2 ? -1 : 1;
			});
			isApprovedOrPending = bookingHistories.get(bookingHistories.size() - 1).getStatus() != BookingStatus.CANC;
			return isApprovedOrPending;
		}).toList();
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
