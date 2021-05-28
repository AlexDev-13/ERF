package com.gov.erf.endpoint.claim.action.responsibleOrgan.impl;

import com.gov.erf.dto.http.claims.action.responsibleOrgan.ResponsibleOrganDto;
import com.gov.erf.dto.http.claims.action.responsibleOrgan.request.AddResponsibleOrganRequestDto;
import com.gov.erf.endpoint.claim.action.responsibleOrgan.ResponsibleOrganEndpoint;
import com.gov.erf.mapper.claim.action.ResponsibleOrganMapper;
import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.responsibleOrgan.ResponsibleOrgan;
import com.gov.erf.models.claims.responsibleOrgan.request.AddResponsibleOrganRequest;
import com.gov.erf.service.action.MovementActionService;
import com.gov.erf.service.claim.ClaimService;
import com.gov.erf.service.claim.action.responsibleOrgan.ResponsibleOrganService;
import org.springframework.stereotype.Service;

@Service
public class DefaultResponsibleOrganEndpoint implements ResponsibleOrganEndpoint {

    private final ClaimService claimService;
    private final MovementActionService movementActionService;
    private final ResponsibleOrganService responsibleOrganService;
    private final ResponsibleOrganMapper responsibleOrganMapper;


    public DefaultResponsibleOrganEndpoint
            (
                    ClaimService claimService,
                    MovementActionService movementActionService,
                    ResponsibleOrganService responsibleOrganService,
                    ResponsibleOrganMapper responsibleOrganMapper
            ) {
        this.claimService = claimService;
        this.movementActionService = movementActionService;
        this.responsibleOrganService = responsibleOrganService;
        this.responsibleOrganMapper = responsibleOrganMapper;
    }

    @Override
    public ResponsibleOrganDto perform(
            Long claimId,
            AddResponsibleOrganRequestDto requestDto
    ) {
        Claim claim = claimService.get(claimId);
        MovementAction action = movementActionService.get(MovementActionType.RESPONSIBLE_ORGAN_ACCEPT);

        AddResponsibleOrganRequest request = responsibleOrganMapper.toAddResponsibleOrganRequest(requestDto,MovementActionType.RESPONSIBLE_ORGAN_ACCEPT);

        ResponsibleOrgan responsibleOrgan = responsibleOrganService.add(claim, request);

        return responsibleOrganMapper.toAcceptResponsibleOrganDto(responsibleOrgan);
    }
}
