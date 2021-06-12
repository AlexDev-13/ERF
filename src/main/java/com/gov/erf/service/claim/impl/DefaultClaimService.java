package com.gov.erf.service.claim.impl;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;
import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.models.point.MovementPointType;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.repository.claim.AuthorizedBodyRepository;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.repository.claim.ResponsibleBodyRepository;
import com.gov.erf.repository.claim.TableCommissionRepository;
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
    private final ResponsibleBodyRepository responsibleBodyRepository;
    private final AuthorizedBodyRepository authorizedBodyRepository;
    private final TableCommissionRepository tableCommissionRepository;

    public DefaultClaimService
            (
                    ClaimRepository claimRepository,
                    MovementPointService pointService,
                    MovementActionService actionService,
                    ResponsibleBodyRepository responsibleBodyRepository,
                    AuthorizedBodyRepository authorizedBodyRepository,
                    TableCommissionRepository tableCommissionRepository
            ) {
        this.claimRepository = claimRepository;
        this.pointService = pointService;
        this.actionService = actionService;
        this.responsibleBodyRepository = responsibleBodyRepository;
        this.authorizedBodyRepository = authorizedBodyRepository;
        this.tableCommissionRepository = tableCommissionRepository;
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
    public ResponsibleBody create(ResponsibleBodyRequest request) {

        var responsibleBody = new ResponsibleBody();

        MovementActionType actionType = request.getDecision() ? MovementActionType.ORGAN_ACCEPT : MovementActionType.ORGAN_REJECT;

        MovementAction action = actionService.get(actionType);
        MovementPointType pointType = request.getDecision() ? MovementPointType.ACCEPT : MovementPointType.REJECT;
        MovementPoint point = pointService.get(pointType);
        var claim = request.getClaim();
        claim.setAction(action);
        claim.setPoint(point);

        responsibleBody.setClaim(claim);
        responsibleBody.setCause(request.getCause());
        responsibleBody.setDecision(actionType);

        return responsibleBodyRepository.save(responsibleBody);
    }

    @Override
    public AuthorizedBody create(AuthorizedBodyRequest request) {

        var authorizedBody = new AuthorizedBody();

        MovementActionType actionType = request.getDecision() ? MovementActionType.OPERATOR_ACCEPT : MovementActionType.OPERATOR_REJECT;

        MovementAction action = actionService.get(actionType);
        MovementPointType pointType = request.getDecision() ? MovementPointType.ACCEPT : MovementPointType.REJECT;
        MovementPoint point = pointService.get(pointType);
        var claim = request.getClaim();
        claim.setAction(action);
        claim.setPoint(point);

        authorizedBody.setClaim(request.getClaim());
        authorizedBody.setCause(request.getCause());
        authorizedBody.setDecision(actionType);

        return authorizedBodyRepository.save(authorizedBody);
    }

    @Override
    public TableCommission create(TableCommissionRequest request) {
        var tableCommission = new TableCommission();

        MovementActionType actionType = request.getDecision() ? MovementActionType.COMMISSION_ACCEPT : MovementActionType.COMMISSION_REJECT;
        ;

        MovementAction action = actionService.get(actionType);
        MovementPointType pointType = request.getDecision() ? MovementPointType.ACCEPT : MovementPointType.REJECT;
        MovementPoint point = pointService.get(pointType);
        var claim = request.getClaim();
        claim.setAction(action);
        claim.setPoint(point);

        tableCommission.setClaim(request.getClaim());
        tableCommission.setCause(request.getCause());
        tableCommission.setDecision(actionType);

        return tableCommissionRepository.save(tableCommission);
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
