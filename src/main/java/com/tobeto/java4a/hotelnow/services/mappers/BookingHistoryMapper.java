package com.tobeto.java4a.hotelnow.services.mappers;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.BookingHistory;
import com.tobeto.java4a.hotelnow.entities.concretes.CancellationReason;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookinghistories.AddBookingHistoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.AddBookingHistoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookinghistories.ListBookingHistoryResponse;

@Mapper
public interface BookingHistoryMapper {

	BookingHistoryMapper INSTANCE = Mappers.getMapper(BookingHistoryMapper.class);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "userId", source = "user.id")
	@Mapping(target = "cancellationReasonId", expression = "java(bookingHistory.getCancellationReason()!=null?bookingHistory.getCancellationReason().getId():null)")
	@Mapping(target = "cancellationReason", expression = "java(bookingHistory.getCancellationReason()!=null?bookingHistory.getCancellationReason().getReason():null)")
	ListBookingHistoryResponse listResponseFromBookingHistory(BookingHistory bookingHistory);

	@Mapping(target = "bookingId", source = "booking.id")
	@Mapping(target = "userId", source = "user.id")
	@Mapping(target = "cancellationReasonId", expression = "java(bookingHistory.getCancellationReason()!=null?bookingHistory.getCancellationReason().getId():null)")
	@Mapping(target = "cancellationReason", expression = "java(bookingHistory.getCancellationReason()!=null?bookingHistory.getCancellationReason().getReason():null)")
	AddBookingHistoryResponse addResponseFromBookingHistory(BookingHistory bookingHistory);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "booking.id", expression = "java(addBookingHistoryRequest.getBookingId())")
	@Mapping(target = "user.id", expression = "java(addBookingHistoryRequest.getUserId())")
	@Mapping(target = "editedAt", source = "editedAt")
	@Mapping(target = "cancellationReason", expression = "java(mapCancellationReasonForAddRequest(addBookingHistoryRequest.getCancellationReasonId()))")
	BookingHistory bookingHistoryfromAddRequest(AddBookingHistoryRequest addBookingHistoryRequest,
			LocalDateTime editedAt);

	default CancellationReason mapCancellationReasonForAddRequest(Integer cancellationReasonId) {
		CancellationReason cancellationReason = null;
		if (cancellationReasonId != null) {
			cancellationReason = new CancellationReason();
			cancellationReason.setId(cancellationReasonId);
		}
		return cancellationReason;
	}
}
