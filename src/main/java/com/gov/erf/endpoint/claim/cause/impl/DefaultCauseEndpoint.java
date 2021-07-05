package com.gov.erf.endpoint.claim.cause.impl;

import com.gov.erf.dto.http.claim.CauseDto;
import com.gov.erf.dto.http.claim.request.AddCauseOfFactorRequestDto;
import com.gov.erf.endpoint.claim.cause.CauseEndpoint;
import com.gov.erf.mapper.claim.CauseMapper;
import com.gov.erf.models.claims.Cause;
import com.gov.erf.models.claims.request.AddCauseRequest;
import com.gov.erf.service.claim.CauseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class DefaultCauseEndpoint implements CauseEndpoint {

    private final CauseService causeService;
    private final CauseMapper causeMapper;

    public DefaultCauseEndpoint(CauseService causeService, CauseMapper causeMapper) {
        this.causeService = causeService;
        this.causeMapper = causeMapper;
    }


    @Override
    public CauseDto get(Long id) {

        Cause cause = causeService.get(id);
        return causeMapper.toCauseDto(cause);
    }

    @Override
    public Collection<CauseDto> getAll() {

        Collection<Cause> causes = causeService.getAll();
        Collection<CauseDto> causeDtos = new ArrayList<>();
        for (Cause cause : causes) {
            causeDtos.add(causeMapper.toCauseDto(cause));
        }

        return causeDtos;
    }

    @Override
    public CauseDto create(AddCauseOfFactorRequestDto addCauseOfFactorRequestDto) {

        AddCauseRequest addCauseRequest = causeMapper.toAddCouseRequest(addCauseOfFactorRequestDto);

        Cause cause = causeService.create(addCauseRequest);


        return causeMapper.toCauseDto(cause);
    }
}
