package com.gov.erf.service.statistic;

import com.gov.erf.config.predicate.builder.StatPage;
import com.gov.erf.config.predicate.criteria.StatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import org.springframework.data.domain.Page;

public interface StatisticService {

    Page<StatisticDto> calculate(StatPage statPage, StatCriteria statCriteria);

}
