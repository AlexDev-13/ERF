package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.Organ;
import com.gov.erf.repository.claim.OrganRepository;
import com.gov.erf.service.claim.OrganService;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrganService implements OrganService {

    private final OrganRepository organRepository;

    public DefaultOrganService(OrganRepository organRepository) {
        this.organRepository = organRepository;
    }

    @Override
    public Organ get(Long id) {
        return organRepository.findById(id).orElseThrow();
    }
}
