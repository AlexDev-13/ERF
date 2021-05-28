package com.gov.erf.endpoint.claim.action.responsibleOrgan;

import com.gov.erf.dto.http.claims.action.responsibleOrgan.ResponsibleOrganDto;
import com.gov.erf.dto.http.claims.action.responsibleOrgan.request.AddResponsibleOrganRequestDto;

public interface ResponsibleOrganEndpoint {

    ResponsibleOrganDto perform(Long claimId, AddResponsibleOrganRequestDto requestDto);

}
