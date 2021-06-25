package com.gov.erf.endpoint.claim.activity.impl;

import com.gov.erf.dto.http.claim.EconomicActivityDto;
import com.gov.erf.dto.http.claim.request.AddEconomicActivityRequestDto;
import com.gov.erf.endpoint.claim.activity.EconomicActivityEndpoint;
import com.gov.erf.mapper.claim.EconomicActivityMapper;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.request.AddEconomicActivityRequest;
import com.gov.erf.service.claim.EconomicActivityService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultEconomicActivityEndpoint implements EconomicActivityEndpoint {

    private final EconomicActivityMapper economicActivityMapper;
    private final EconomicActivityService economicActivityService;

    public DefaultEconomicActivityEndpoint
            (
                    EconomicActivityMapper economicActivityMapper,
                    EconomicActivityService economicActivityService
            ) {
        this.economicActivityMapper = economicActivityMapper;
        this.economicActivityService = economicActivityService;
    }

    @Override
    public EconomicActivityDto create(AddEconomicActivityRequestDto addEconomicActivityRequestDto) {

        AddEconomicActivityRequest request = economicActivityMapper.toAddEconomicActivityRequest(addEconomicActivityRequestDto);

        EconomicActivity economicActivity = economicActivityService.create(request);

        return economicActivityMapper.toEconomicActivityDto(economicActivity);
    }

    @Override
    public EconomicActivityDto get(Long id) {

        EconomicActivity economicActivity = economicActivityService.get(id);

        return economicActivityMapper.toEconomicActivityDto(economicActivity);
    }

    @Override
    public Collection<EconomicActivityDto> getAll() {

        Collection<EconomicActivity> economicActivities = economicActivityService.getAll();

        return economicActivityMapper.toEconomicActivityDtos(economicActivities);
    }
}
