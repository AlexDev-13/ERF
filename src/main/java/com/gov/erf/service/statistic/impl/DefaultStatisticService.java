package com.gov.erf.service.statistic.impl;

import com.gov.erf.config.predicate.builder.StatPage;
import com.gov.erf.config.predicate.criteria.StatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.models.status.Status;
import com.gov.erf.models.status.StatusType;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.repository.stat.StatisticRepository;
import com.gov.erf.service.statistic.StatisticService;
import com.gov.erf.service.status.StatusService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DefaultStatisticService implements StatisticService {

    private final ClaimRepository claimRepository;
    private final StatisticRepository statisticRepository;
    private final StatusService statusService;

    public DefaultStatisticService(ClaimRepository claimRepository, StatisticRepository statisticRepository, StatusService statusService) {
        this.claimRepository = claimRepository;
        this.statisticRepository = statisticRepository;
        this.statusService = statusService;
    }

    @Override
    public StatisticDto calculate() {

        var stat = new StatisticDto();

        var status = new Status();

        var count = claimRepository.findAll().stream().count();

        status = statusService.get(StatusType.APPROVED);
        stat.setReady((claimRepository.findAllByStatus(status).stream().count()*100)/count);
        status = statusService.get(StatusType.UNDER_CONSIDERATION);
        stat.setUnderConsideration((claimRepository.findAllByStatus(status).stream().count()*100)/count);
        status = statusService.get(StatusType.IN_PROCESSING);
        stat.setInProcessing((claimRepository.findAllByStatus(status).stream().count()*100)/count);
        status = statusService.get(StatusType.DENIED);
        stat.setRenouncement((claimRepository.findAllByStatus(status).stream().count()*100)/count);
        return stat;
    }
}
