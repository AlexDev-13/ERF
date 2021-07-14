package com.gov.erf.service.statistic;

import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Region;

public interface StatisticService {

    StatisticDto calculate();

    StatisticDto calculateByRegion(Region region);

    StatisticDto calculateByActivity(EconomicActivity economicActivity);

    StatisticDto calculateByRegionAndActivity(Region region, EconomicActivity economicActivity);
}
