package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.CancellationReason;
import com.tobeto.java4a.hotelnow.services.dtos.requests.cancellationreasons.AddCancellationReasonRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.AddCancellationReasonResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CancellationReasonMapper {

    CancellationReasonMapper INSTANCE = Mappers.getMapper(CancellationReasonMapper.class);

    ListCancellationReasonResponse listResponseFromCancellationReason(CancellationReason cancellationReason);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "bookingHistories" , ignore = true)
    CancellationReason cancellationReasonFromAddRequest(AddCancellationReasonRequest cancellationReasonRequest);

    AddCancellationReasonResponse addResponseFromCancellationReason(CancellationReason savedCancellationReason);
}
