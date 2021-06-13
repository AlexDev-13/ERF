package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.OrganDto;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.request.AddOrganRequest;

public interface OrganMapper {

    AddOrganRequest toAddOrganRequest(OrganDto organ);
    OrganDto toOrganDto(Organ organ);
}
