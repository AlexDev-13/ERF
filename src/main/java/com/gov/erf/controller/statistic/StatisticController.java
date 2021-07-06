package com.gov.erf.controller.statistic;

import com.gov.erf.config.predicate.builder.StatPage;
import com.gov.erf.config.predicate.criteria.StatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.endpoint.statistic.StatisticEndpoint;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/stat")
public class StatisticController {

    private final StatisticEndpoint statisticEndpoint;

    public StatisticController(StatisticEndpoint statisticEndpoint) {
        this.statisticEndpoint = statisticEndpoint;
    }


    @GetMapping
    public Page<StatisticDto> getStatistic(StatPage statPage, StatCriteria statCriteria){
        return statisticEndpoint.get(statPage,statCriteria);
    }

}
