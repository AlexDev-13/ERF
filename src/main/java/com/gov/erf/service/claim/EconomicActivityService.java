package com.gov.erf.service.claim;

import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.request.AddEconomicActivityRequest;

import java.util.Collection;

public interface EconomicActivityService {

    EconomicActivity get(Long id);

    EconomicActivity create(AddEconomicActivityRequest request);

    Collection<EconomicActivity> getAll();
}
