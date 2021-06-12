package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.modules.models.AppFile;

import java.util.Collection;

public interface ClaimService {

    Claim create(AddClaimRequest request);
    Claim updateFile(Claim claim, AppFile appFile);
    Collection<Claim> getAll();
    Claim getById(Long id);

}
