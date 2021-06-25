package com.gov.erf.endpoint.claim.region.impl;

import com.gov.erf.dto.http.claim.RegionDto;
import com.gov.erf.dto.http.claim.request.AddRegionRequestDto;
import com.gov.erf.endpoint.claim.region.RegionEndpoint;
import com.gov.erf.mapper.claim.RegionMapper;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddRegionRequest;
import com.gov.erf.service.claim.RegionService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultRegionEndpoint implements RegionEndpoint {

    private final RegionService regionService;
    private final RegionMapper regionMapper;

    public DefaultRegionEndpoint
            (
                    RegionService regionService,
                    RegionMapper regionMapper
            ) {
        this.regionService = regionService;
        this.regionMapper = regionMapper;
    }

    @Override
    public RegionDto getById(Long id) {

        Region region = regionService.get(id);
        return regionMapper.toRegionDto(region);
    }

    @Override
    public Collection<RegionDto> getAll() {

        Collection<Region> regions = regionService.getAll();

        return regionMapper.toRegionDtos(regions);
    }

    @Override
    public RegionDto create(AddRegionRequestDto addRegionRequestDto) {

        AddRegionRequest regionRequest = regionMapper.toAddRegionRequest(addRegionRequestDto);

        Region region = regionService.create(regionRequest);

        return regionMapper.toRegionDto(region);
    }
}
