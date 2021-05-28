package com.gov.erf.mapper.claim.action;

import com.gov.erf.dto.http.claims.action.responsibleOrgan.ResponsibleOrganDto;
import com.gov.erf.dto.http.claims.action.responsibleOrgan.request.AddResponsibleOrganRequestDto;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.responsibleOrgan.ResponsibleOrgan;
import com.gov.erf.models.claims.responsibleOrgan.request.AddResponsibleOrganRequest;

public interface ResponsibleOrganMapper {

    AddResponsibleOrganRequest toAddResponsibleOrganRequest(AddResponsibleOrganRequestDto addResponsibleOrganRequestDto, MovementActionType type);

    ResponsibleOrganDto toAcceptResponsibleOrganDto(ResponsibleOrgan organ);
}
