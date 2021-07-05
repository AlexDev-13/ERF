package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.Cause;
import com.gov.erf.models.claims.request.AddCauseRequest;
import com.gov.erf.repository.claim.CauseRepository;
import com.gov.erf.service.claim.CauseService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultCauseService implements CauseService {

    private final CauseRepository causeRepository;

    public DefaultCauseService(CauseRepository causeRepository) {
        this.causeRepository = causeRepository;
    }

    @Override
    public Cause get(Long id) {
        return causeRepository.findById(id).orElseThrow();
    }

    @Override
    public Collection<Cause> getAll() {
        return causeRepository.findAll();
    }

    @Override
    public Cause create(AddCauseRequest addCauseRequest) {

        var cause = new Cause();

        cause.setTitle(addCauseRequest.getTitle());

        return causeRepository.save(cause);
    }
}
