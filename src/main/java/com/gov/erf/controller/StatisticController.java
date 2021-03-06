package com.gov.erf.controller;

import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.endpoint.statistic.StatisticEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stat")
public class StatisticController {

    private final StatisticEndpoint statisticEndpoint;

    public StatisticController(StatisticEndpoint statisticEndpoint) {
        this.statisticEndpoint = statisticEndpoint;
    }


    @GetMapping
    public StatisticDto getStatistic(){
        return statisticEndpoint.get();
    }

}
