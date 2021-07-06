package com.gov.erf.endpoint.statistic.impl;

import com.gov.erf.config.predicate.builder.StatPage;
import com.gov.erf.config.predicate.criteria.StatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.endpoint.statistic.StatisticEndpoint;
import com.gov.erf.service.statistic.StatisticService;
import org.springframework.data.domain.Page;
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
}
