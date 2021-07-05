package com.gov.erf.endpoint.claim.cause;

import com.gov.erf.dto.http.claim.CauseDto;
import com.gov.erf.dto.http.claim.request.AddCauseOfFactorRequestDto;

import java.util.Collection;

public interface CauseEndpoint {

    CauseDto get(Long id);
    Collection<CauseDto> getAll();
    CauseDto create(AddCauseOfFactorRequestDto addCauseOfFactorRequestDto);
}
