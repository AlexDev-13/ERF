package com.gov.erf.endpoint.statistic;

import com.gov.erf.config.predicate.criteria.ClaimStatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Region;

public interface StatisticEndpoint {

    StatisticDto get();

    StatisticDto getByRegion(Region region);

    StatisticDto getByActivity(EconomicActivity economicActivity);

    StatisticDto getClaimByRegionAndActivity(ClaimStatCriteria claimStatCriteria);
}
