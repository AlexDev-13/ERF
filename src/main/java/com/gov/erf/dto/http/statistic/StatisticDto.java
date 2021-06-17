package com.gov.erf.dto.http.statistic;


import lombok.Data;

@Data
public class StatisticDto {

    private Long ready;
    private Long inProcessing;
    private Long underConsideration;
    private Long renouncement;

}
