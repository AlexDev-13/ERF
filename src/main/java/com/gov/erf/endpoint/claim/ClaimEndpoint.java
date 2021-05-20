package com.gov.erf.endpoint.claim;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;

public interface ClaimEndpoint {

    ClaimDto create (AddClaimRequestDto addClaimRequestDto);
}
