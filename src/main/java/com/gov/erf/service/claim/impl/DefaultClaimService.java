package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.service.claim.ClaimService;
import org.springframework.stereotype.Service;

@Service
public class DefaultClaimService implements ClaimService {

    private final ClaimRepository claimRepository;

    public DefaultClaimService
            (
                    ClaimRepository claimRepository
            ) {
        this.claimRepository = claimRepository;
    }

    @Override
    public Claim create(AddClaimRequest request) {

        var claim = new Claim();

        claim.setOrgan(request.getOrgan());
        claim.setRegion(request.getRegion());
        claim.setEconomicActivity(request.getEconomicActivity());
        claim.setEmpowerment(request.getEmpowerment());
        claim.setCauseOfFactor(request.getCauseOfFactor());
        claim.setProblemOfDescription(request.getProblemOfDescription());
        claim.setIdentificationFactor(request.getIdentificationFactor());

        return claimRepository.save(claim);
    }

    @Override
    public Claim updateFile(Claim claim, AppFile appFile) {
        claim.setFile(appFile);
        return claimRepository.save(claim);
    }
}
