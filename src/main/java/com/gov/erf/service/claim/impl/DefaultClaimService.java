package com.gov.erf.service.claim.impl;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.service.action.MovementActionService;
import com.gov.erf.service.claim.ClaimService;
import com.gov.erf.service.point.MovementPointService;
import com.gov.erf.service.roadmap.MovementPointSearchService;
import org.springframework.stereotype.Service;

@Service
public class DefaultClaimService implements ClaimService {

    private final ClaimRepository claimRepository;
    private final MovementActionService movementActionService;
    private final MovementPointService movementPointService;
    private final MovementPointSearchService movementPointSearchService;

    public DefaultClaimService
            (
                    ClaimRepository claimRepository,
                    MovementActionService movementActionService,
                    MovementPointService movementPointService,
                    MovementPointSearchService movementPointSearchService
            ) {
        this.claimRepository = claimRepository;
        this.movementActionService = movementActionService;
        this.movementPointService = movementPointService;
        this.movementPointSearchService = movementPointSearchService;
    }

    @Override
    public Claim create(AddClaimRequest request) {

        var claim = new Claim();

        MovementAction action = movementActionService.get(MovementActionType.REGISTER);
        MovementPoint point = movementPointSearchService.getTargetPointByStartAction(action);

        claim.setOrgan(request.getOrgan());
        claim.setRegion(request.getRegion());
        claim.setPoint(point);
        claim.setAction(action);
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
