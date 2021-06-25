package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.RegionDto;
import com.gov.erf.dto.http.claim.request.AddOrganRequestDto;
import com.gov.erf.dto.http.claim.request.AddRegionRequestDto;
import com.gov.erf.mapper.claim.RegionMapper;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddRegionRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DefaultRegionMapper implements RegionMapper {


    @Override
    public AddRegionRequest toAddRegionRequest(AddRegionRequestDto region) {
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

    @Override
    public Collection<RegionDto> toRegionDtos(Collection<Region> regions) {

        Collection<RegionDto> regionDtos = new ArrayList<>();

        for (Region region: regions){
            regionDtos.add(toRegionDto(region));
        }

        return regionDtos;
    }
}
