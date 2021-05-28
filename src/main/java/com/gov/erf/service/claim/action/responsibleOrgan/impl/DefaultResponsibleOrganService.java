package com.gov.erf.service.claim.action.responsibleOrgan.impl;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.responsibleOrgan.ResponsibleOrgan;
import com.gov.erf.models.claims.responsibleOrgan.request.AddResponsibleOrganRequest;
import com.gov.erf.repository.claim.action.ResponsibleOrganRepository;
import com.gov.erf.service.claim.action.responsibleOrgan.ResponsibleOrganService;
import org.springframework.stereotype.Service;

@Service
public class DefaultResponsibleOrganService implements ResponsibleOrganService {

    private final ResponsibleOrganRepository responsibleOrganRepository;

    public DefaultResponsibleOrganService
            (
                    ResponsibleOrganRepository responsibleOrganRepository
            ) {
        this.responsibleOrganRepository = responsibleOrganRepository;
    }


    @Override
    public ResponsibleOrgan get(Long id) {
        return responsibleOrganRepository.findById(id).orElseThrow();
    }

    @Override
    public ResponsibleOrgan add(Claim claim, AddResponsibleOrganRequest addResponsibleOrganRequest) {

        ResponsibleOrgan responsibleOrgan = new ResponsibleOrgan();

        responsibleOrgan.setClaim(claim);
        responsibleOrgan.setTitle(addResponsibleOrganRequest.getTitle());
        responsibleOrgan.setType(addResponsibleOrganRequest.getType());

        return responsibleOrganRepository.save(responsibleOrgan);
    }
}
