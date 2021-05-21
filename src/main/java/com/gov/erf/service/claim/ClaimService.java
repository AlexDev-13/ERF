package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.modules.models.AppFile;

public interface ClaimService {

    Claim create(AddClaimRequest request);
    Claim updateFile(Claim claim, AppFile appFile);

}
