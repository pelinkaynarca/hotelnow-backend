package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.CancellationReason;
import com.tobeto.java4a.hotelnow.repositories.CancellationReasonRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CancellationReasonService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.cancellationreasons.AddCancellationReasonRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.AddCancellationReasonResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;
import com.tobeto.java4a.hotelnow.services.mappers.CancellationReasonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CancellationServiceImpl implements CancellationReasonService {

	private CancellationReasonRepository cancellationReasonRepository;

	@Override
	public List<ListCancellationReasonResponse> getAll() {
		List<CancellationReason> cancellationReasons = cancellationReasonRepository.findAll();
		return cancellationReasons.stream().map(CancellationReasonMapper.INSTANCE::listResponseFromCancellationReason)
				.collect(Collectors.toList());
	}

	@Override
	public ListCancellationReasonResponse getById(int id) {
		CancellationReason cancellationReason = cancellationReasonRepository.findById(id).orElse(null);
		return CancellationReasonMapper.INSTANCE.listResponseFromCancellationReason(cancellationReason);
	}

	@Override
	public AddCancellationReasonResponse add(AddCancellationReasonRequest request) {
		CancellationReason cancellationReason = CancellationReasonMapper.INSTANCE
				.cancellationReasonFromAddRequest(request);

		CancellationReason savedCancellationReason = cancellationReasonRepository.save(cancellationReason);
		return CancellationReasonMapper.INSTANCE.addResponseFromCancellationReason(savedCancellationReason);
	}

	@Override
	public CancellationReason addCancellationReason(CancellationReason cancellationReason) {
		return cancellationReasonRepository.save(cancellationReason);
	}
}
