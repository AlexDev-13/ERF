package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.RegionDto;
import com.gov.erf.mapper.claim.RegionMapper;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddRegionRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultRegionMapper implements RegionMapper {


    @Override
    public AddRegionRequest toAddRegionRequest(RegionDto region) {
        return AddRegionRequest
                .builder()
                .title(region.getTitle())
                .build();
    }

    @Override
    public RegionDto toRegionDto(Region region) {

        var regionDto = new RegionDto();
        regionDto.setId(region.getId());
        regionDto.setTitle(region.getTitle());

        return regionDto;
    }
}
