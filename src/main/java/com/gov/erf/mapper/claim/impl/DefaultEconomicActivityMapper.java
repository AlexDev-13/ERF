package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.EconomicActivityDto;
import com.gov.erf.dto.http.claim.request.AddEconomicActivityRequestDto;
import com.gov.erf.mapper.claim.EconomicActivityMapper;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.request.AddEconomicActivityRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DefaultEconomicActivityMapper implements EconomicActivityMapper {


    @Override
    public AddEconomicActivityRequest toAddEconomicActivityRequest(AddEconomicActivityRequestDto economicActivity) {
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

    @Override
    public Collection<EconomicActivityDto> toEconomicActivityDtos(Collection<EconomicActivity> economicActivities) {

        Collection<EconomicActivityDto> economicActivityDtos = new ArrayList<>();

        for (EconomicActivity economicActivity : economicActivities) {
            economicActivityDtos.add(toEconomicActivityDto(economicActivity));
        }
        return economicActivityDtos;
    }
}
