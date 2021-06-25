package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.RegionDto;
import com.gov.erf.dto.http.claim.request.AddRegionRequestDto;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddRegionRequest;

import java.util.Collection;

public interface RegionMapper {

    AddRegionRequest toAddRegionRequest(AddRegionRequestDto region);

    RegionDto toRegionDto(Region region);

    Collection<RegionDto> toRegionDtos(Collection<Region> regions);

}
