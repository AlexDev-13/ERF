package com.gov.erf.service.claim.action.responsibleOrgan;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.responsibleOrgan.ResponsibleOrgan;
import com.gov.erf.models.claims.responsibleOrgan.request.AddResponsibleOrganRequest;

public interface ResponsibleOrganService {

    ResponsibleOrgan get(Long id);

    ResponsibleOrgan add(Claim claim, AddResponsibleOrganRequest addResponsibleOrganRequest);

}
