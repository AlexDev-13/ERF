package com.gov.erf.endpoint.claim.region;

import com.gov.erf.dto.http.claim.RegionDto;
import com.gov.erf.dto.http.claim.request.AddRegionRequestDto;

import java.util.Collection;

public interface RegionEndpoint {

    RegionDto getById(Long id);

    Collection<RegionDto> getAll();

    RegionDto create(AddRegionRequestDto addRegionRequestDto);

    RegionDto deleteById(Long id);
}
