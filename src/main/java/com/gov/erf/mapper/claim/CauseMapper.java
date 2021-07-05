package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.CauseDto;
import com.gov.erf.dto.http.claim.request.AddCauseOfFactorRequestDto;
import com.gov.erf.models.claims.Cause;
import com.gov.erf.models.claims.request.AddCauseRequest;

public interface CauseMapper {

    CauseDto toCauseDto(Cause cause);
    AddCauseRequest toAddCouseRequest(AddCauseOfFactorRequestDto addCauseOfFactorRequestDto);

}
