package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.request.AddOrganRequest;
import com.gov.erf.repository.claim.OrganRepository;
import com.gov.erf.service.claim.OrganService;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    @Override
    public Collection<Organ> getAll() {
        return organRepository.findAll();
    }

    @Override
    public Organ create(AddOrganRequest addOrganRequest) {

        var organ = new Organ();

        organ.setTitle(addOrganRequest.getTitle());


        return organRepository.save(organ);
    }
}
