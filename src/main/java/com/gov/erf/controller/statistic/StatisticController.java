package com.gov.erf.controller.statistic;

import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.endpoint.statistic.StatisticEndpoint;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Region;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/stat")
public class StatisticController {

    private final StatisticEndpoint statisticEndpoint;

    public StatisticController(StatisticEndpoint statisticEndpoint) {
        this.statisticEndpoint = statisticEndpoint;
    }


    @GetMapping
    public StatisticDto getStatistic() {
        return statisticEndpoint.get();
    }
    //new-activity
    @GetMapping("/region")
    public StatisticDto getStatisticByRegion(@RequestParam("regionId") Region region) {
        return  statisticEndpoint.getByRegion(region);
    }

    @GetMapping("/activity")
    public StatisticDto getStatisticByActivity(@RequestParam("activityId") EconomicActivity economicActivity) {
        return statisticEndpoint.getByActivity(economicActivity);
    }

}
