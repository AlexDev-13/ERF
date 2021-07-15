package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.request.AddOrganRequest;

import java.util.Collection;

public interface OrganService {

    Organ get(Long id);
    Collection<Organ> getAll();
    Organ create(AddOrganRequest addOrganRequest);
    Organ delete(Long id);
}
