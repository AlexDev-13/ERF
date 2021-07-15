package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddRegionRequest;

import java.util.Collection;

public interface RegionService {

    Region get(Long id);
    Collection<Region> getAll();
    Region create (AddRegionRequest regionRequest);
    Region delete(Long id);
    Region findRegion(String region);
}
