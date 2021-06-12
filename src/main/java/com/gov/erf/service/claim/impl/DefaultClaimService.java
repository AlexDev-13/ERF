package com.gov.erf.service.claim.impl;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.models.point.MovementPointType;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.service.action.MovementActionService;
import com.gov.erf.service.claim.ClaimService;
import com.gov.erf.service.point.MovementPointService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultClaimService implements ClaimService {

    private final ClaimRepository claimRepository;
    private final MovementPointService pointService;
    private final MovementActionService actionService;
    public DefaultClaimService
            (
                    ClaimRepository claimRepository,
                    MovementPointService pointService,
                    MovementActionService actionService) {
        this.claimRepository = claimRepository;
        this.pointService = pointService;
        this.actionService = actionService;
    }

    @Override
    public Claim create(AddClaimRequest request) {

        MovementPoint point = pointService.get(MovementPointType.ADMISSION);
        MovementAction action = actionService.get(MovementActionType.REGISTER);

        var claim = new Claim();

        claim.setOrgan(request.getOrgan());
        claim.setRegion(request.getRegion());
        claim.setEconomicActivity(request.getEconomicActivity());
        claim.setEmpowerment(request.getEmpowerment());
        claim.setCauseOfFactor(request.getCauseOfFactor());
        claim.setPoint(point);
        claim.setAction(action);
        claim.setProblemOfDescription(request.getProblemOfDescription());
        claim.setIdentificationFactor(request.getIdentificationFactor());

        return claimRepository.save(claim);
    }

    @Override
    public Claim updateFile(Claim claim, AppFile appFile) {
        claim.setFile(appFile);
        return claimRepository.save(claim);
    }

    @Override
    public Collection<Claim> getAll() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getById(Long id) {
        return claimRepository.findById(id).orElseThrow();
    }
}
