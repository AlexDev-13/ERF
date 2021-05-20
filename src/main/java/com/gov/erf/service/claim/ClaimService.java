package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;

public interface ClaimService {

    Claim create(AddClaimRequest request);

}
