package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.EconomicActivityDto;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.request.AddEconomicActivityRequest;

public interface EconomicActivityMapper {

    AddEconomicActivityRequest toAddEconomicActivityRequest(EconomicActivityDto economicActivity);
    EconomicActivityDto toEconomicActivityDto(EconomicActivity economicActivity);
}
