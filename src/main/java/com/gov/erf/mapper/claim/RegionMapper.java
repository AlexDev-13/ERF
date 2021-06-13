package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.RegionDto;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddRegionRequest;

public interface RegionMapper {

    AddRegionRequest toAddRegionRequest(RegionDto region);
    RegionDto toRegionDto(Region region);

}
