package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.EconomicActivityDto;
import com.gov.erf.dto.http.claim.request.AddEconomicActivityRequestDto;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.request.AddEconomicActivityRequest;

import java.util.Collection;

public interface EconomicActivityMapper {

    AddEconomicActivityRequest toAddEconomicActivityRequest(AddEconomicActivityRequestDto economicActivity);

    EconomicActivityDto toEconomicActivityDto(EconomicActivity economicActivity);

    Collection<EconomicActivityDto> toEconomicActivityDtos(Collection<EconomicActivity> economicActivities);
}
