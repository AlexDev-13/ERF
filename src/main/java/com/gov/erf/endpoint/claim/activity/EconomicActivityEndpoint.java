package com.gov.erf.endpoint.claim.activity;

import com.gov.erf.dto.http.claim.EconomicActivityDto;
import com.gov.erf.dto.http.claim.request.AddEconomicActivityRequestDto;

import java.util.Collection;

public interface EconomicActivityEndpoint {

    EconomicActivityDto create(AddEconomicActivityRequestDto addEconomicActivityRequestDto);

    EconomicActivityDto get(Long id);

    Collection<EconomicActivityDto> getAll();

}
