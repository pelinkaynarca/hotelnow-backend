package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.CancellationReason;
import com.tobeto.java4a.hotelnow.services.dtos.requests.cancellationreasons.AddCancellationReasonRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.AddCancellationReasonResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;

import java.util.List;

public interface CancellationReasonService {

	List<ListCancellationReasonResponse> getAll();

	ListCancellationReasonResponse getById(int id);

	AddCancellationReasonResponse add(AddCancellationReasonRequest request);

	CancellationReason addCancellationReason(CancellationReason cancellationReason);

}
