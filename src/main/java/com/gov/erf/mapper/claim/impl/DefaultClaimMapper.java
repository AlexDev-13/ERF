package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.EconomicActivityDto;
import com.gov.erf.dto.http.claims.OrganDto;
import com.gov.erf.dto.http.claims.RegionDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.mapper.claim.ClaimMapper;
import com.gov.erf.mapper.claim.EconomicActivityMapper;
import com.gov.erf.mapper.claim.OrganMapper;
import com.gov.erf.mapper.claim.RegionMapper;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.service.claim.EconomicActivityService;
import com.gov.erf.service.claim.OrganService;
import com.gov.erf.service.claim.RegionService;
import org.springframework.stereotype.Service;

@Service
public class DefaultClaimMapper implements ClaimMapper {

    private final ClaimRepository claimRepository;
    private final EconomicActivityService economicActivityService;
    private final OrganService organService;
    private final RegionService regionService;
    private final EconomicActivityMapper economicActivityMapper;
    private final OrganMapper organMapper;
    private final RegionMapper regionMapper;

    public DefaultClaimMapper
            (
                    ClaimRepository claimRepository,
                    EconomicActivityService economicActivityService,
                    OrganService organService,
                    RegionService regionService,
                    EconomicActivityMapper economicActivityMapper,
                    OrganMapper organMapper,
                    RegionMapper regionMapper
            ) {
        this.claimRepository = claimRepository;
        this.economicActivityService = economicActivityService;
        this.organService = organService;
        this.regionService = regionService;
        this.economicActivityMapper = economicActivityMapper;
        this.organMapper = organMapper;
        this.regionMapper = regionMapper;
    }

    @Override
    public AddClaimRequest toClaimRequest(AddClaimRequestDto addClaimRequestDto) {

        EconomicActivity economicActivity = economicActivityService.get(addClaimRequestDto.getEconomicActivityId());
        Region region = regionService.get(addClaimRequestDto.getRegionId());
        Organ organ = organService.get(addClaimRequestDto.getOrganId());

        return AddClaimRequest
                .builder()
                .economicActivity(economicActivity)
                .region(region)
                .organ(organ)
                .causeOfFactor(addClaimRequestDto.getCauseOfFactor())
                .empowerment(addClaimRequestDto.getEmpowerment())
                .identificationFactor(addClaimRequestDto.getIdentificationFactor())
                .problemOfDescription(addClaimRequestDto.getProblemOfDescription())
                .build();
    }

    @Override
    public ClaimDto toClaimDto(Claim claim) {

        EconomicActivityDto economicActivityDto = economicActivityMapper.toEconomicActivityDto(claim.getEconomicActivity());
        OrganDto organDto = organMapper.toOrganDto(claim.getOrgan());
        RegionDto regionDto = regionMapper.toRegionDto(claim.getRegion());

        var claimDto = new ClaimDto();
        claimDto.setEconomicActivity(economicActivityDto);
        claimDto.setOrgan(organDto);
        claimDto.setRegion(regionDto);
        claimDto.setEmpowerment(claim.getEmpowerment());
        claimDto.setCauseOfFactor(claim.getCauseOfFactor());
        claimDto.setIdentificationFactor(claim.getIdentificationFactor());
        claimDto.setProblemOfDescription(claim.getProblemOfDescription());

        return claimDto;
    }
}
