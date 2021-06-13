package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.EconomicActivityDto;
import com.gov.erf.mapper.claim.EconomicActivityMapper;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.request.AddEconomicActivityRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultEconomicActivityMapper implements EconomicActivityMapper {


    @Override
    public AddEconomicActivityRequest toAddEconomicActivityRequest(EconomicActivityDto economicActivity) {
        return AddEconomicActivityRequest
                .builder()
                .title(economicActivity.getTitle())
                .build();
    }

    @Override
    public EconomicActivityDto toEconomicActivityDto(EconomicActivity economicActivity) {

        var economicActivityDto = new EconomicActivityDto();

        economicActivityDto.setId(economicActivity.getId());
        economicActivityDto.setTitle(economicActivity.getTitle());

        return economicActivityDto;
    }
}
