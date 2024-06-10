package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.enums.BookingStatus;
import com.tobeto.java4a.hotelnow.core.enums.PaymentStatus;
import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.entities.concretes.Booking;
import com.tobeto.java4a.hotelnow.entities.concretes.BookingHistory;
import com.tobeto.java4a.hotelnow.entities.concretes.Customer;
import com.tobeto.java4a.hotelnow.entities.concretes.Payment;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.BookingRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookedRoomTypeService;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingHistoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.BookingService;
import com.tobeto.java4a.hotelnow.services.abstracts.CustomerService;
import com.tobeto.java4a.hotelnow.services.abstracts.PaymentService;
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
	private final PaymentService paymentService;

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
	public AddBookingResponse add(AddBookingRequest request) {
		// Get logged in user
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(email);
		Customer customer = customerService.getById(loggedInUser.getId());

		// Save booking
		Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request, customer);
		Booking savedBooking = bookingRepository.save(booking);

		// Save booked room types
		List<AddBookedRoomTypeRequest> addBookedRoomTypeRequest = request.getBookedRoomTypes();
		List<BookedRoomType> bookedRoomTypes = BookedRoomTypeMapper.INSTANCE
				.bookedRoomTypesFromAddRequests(addBookedRoomTypeRequest);
		bookedRoomTypes.stream().forEach((brt) -> brt.setBooking(savedBooking));
		List<BookedRoomType> savedBookedRoomTypes = bookedRoomTypeService.addAll(bookedRoomTypes);
		savedBooking.setBookedRoomTypes(savedBookedRoomTypes);

		// Save payment info
		AddPaymentRequest addPaymentRequest = request.getPayment();
		addPaymentRequest.setPaymentStatus(PaymentStatus.WITHDRAW);
		Payment savedPayment = paymentService
				.addPayment(PaymentMapper.INSTANCE.paymentFromAddRequest(addPaymentRequest, savedBooking.getId()));
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
}
