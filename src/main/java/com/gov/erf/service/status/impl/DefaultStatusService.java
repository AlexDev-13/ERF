package com.gov.erf.service.status.impl;

import com.gov.erf.models.status.Status;
import com.gov.erf.models.status.StatusType;
import com.gov.erf.repository.status.StatusRepository;
import com.gov.erf.service.status.StatusService;
import org.springframework.stereotype.Service;

@Service
public class DefaultStatusService implements StatusService {

    private final StatusRepository repository;

    public DefaultStatusService(StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Status get(StatusType statusType) {
        return repository.findByType(statusType);
    }
}
