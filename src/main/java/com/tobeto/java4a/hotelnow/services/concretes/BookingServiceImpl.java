package com.tobeto.java4a.hotelnow.services.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.enums.BookingStatus;
import com.tobeto.java4a.hotelnow.core.enums.PaymentStatus;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.entities.concretes.CancellationReason;
import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Payment;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.BookingRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookedRoomTypeService;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.abstracts.CancellationReasonService;
import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.abstracts.PaymentService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.AddBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookings.CancelBookingRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.payments.AddPaymentRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.AddBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.CancelBookingResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookings.ListBookingResponse;
import com.tobeto.java4a.hotelnow.services.mappers.BookedRoomTypeMapper;
import com.tobeto.java4a.hotelnow.services.mappers.BookingMapper;
import com.tobeto.java4a.hotelnow.services.mappers.PaymentMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;
	private final BookedRoomTypeService bookedRoomTypeService;
	private final UserService userService;
	private final CustomerService customerService;
	private final StaffService staffService;
	private final PaymentService paymentService;
//	private final RoomTypeService roomTypeService;
	private final RoomService roomService;
	private final CancellationReasonService cancellationReasonService;

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
		// Get logged in customer
		Customer loggedInCustomer = customerService.getLoggedInCustomer();

		// Save booking
		Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request, loggedInCustomer);
		booking.setStatus(BookingStatus.PEND);// Set Booking Status
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

		return BookingMapper.INSTANCE.addResponseFromBooking(savedBooking);
	}

	@Override
	public void approve(int bookingId) {
		loggedInUserMustBeManager();

		Booking booking = getById(bookingId);
		booking.setStatus(BookingStatus.APPR);
		bookingRepository.save(booking);
	}

	@Override
	public CancelBookingResponse cancel(CancelBookingRequest request) {
		loggedInUserMustBeManager();

		Booking booking = getById(request.getId());
		booking.setStatus(BookingStatus.CANC);
		if (request.getReason() != null && !request.getReason().isBlank()) {
			CancellationReason cancellationReason = new CancellationReason();
			cancellationReason.setReason(request.getReason());
			CancellationReason savedCancellationReason = cancellationReasonService
					.addCancellationReason(cancellationReason);
			booking.setCancellationReason(savedCancellationReason);
		}
		Booking savedBooking = bookingRepository.save(booking);
		return BookingMapper.INSTANCE.cancelResponseFromBooking(savedBooking);
	}

	private List<Booking> getByStatus(BookingStatus bookingStatus) {
		Staff loggedInStaff = staffService.getLoggedInStaff();
		List<Booking> bookingsOfHotelByStatus = bookingRepository.findByStatusAndHotelId(bookingStatus,
				loggedInStaff.getHotel().getId());
		return bookingsOfHotelByStatus;
	}

	private void loggedInUserMustBeManager() {
		User user = userService.getLoggedInUser();
		if (!user.getAuthorities().contains(Role.MANAGER)) {
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
		}
	}

	// TODO business rule availableRoomsShouldExistBetweenCheckInAndCheckOutDates
	private void availableRoomsShouldExistBetweenCheckInAndCheckOutDates(AddBookingRequest request) {
		LocalDate checkInDate = request.getCheckInDate(), checkOutDate = request.getCheckOutDate();

		List<Booking> approvedBookingsOfHotel = getByStatus(BookingStatus.APPR);
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
