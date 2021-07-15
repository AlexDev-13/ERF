package com.gov.erf.endpoint.statistic.impl;

import com.gov.erf.config.predicate.criteria.ClaimStatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.endpoint.statistic.StatisticEndpoint;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Region;
import com.gov.erf.service.statistic.StatisticService;
import org.springframework.stereotype.Service;

@Service
public class DefaultStatisticEndpoint implements StatisticEndpoint {

    private StatisticService statiscticService;

    public DefaultStatisticEndpoint(StatisticService statiscticService) {
        this.statiscticService = statiscticService;
    }

    @Override
    public StatisticDto get() {
        return statiscticService.calculate();
    }

    @Override
    public StatisticDto getByRegion(Region region) {
        return statiscticService.calculateByRegion(region);
    }

    @Override
    public StatisticDto getByActivity(EconomicActivity economicActivity) {
        return statiscticService.calculateByActivity(economicActivity);
    }

    @Override
    public StatisticDto getClaimByRegionAndActivity(ClaimStatCriteria claimStatCriteria) {
        return statiscticService.calculateClaimsByRegionAndActivity(claimStatCriteria);
    }
}
