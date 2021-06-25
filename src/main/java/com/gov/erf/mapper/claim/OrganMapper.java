package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.OrganDto;
import com.gov.erf.dto.http.claim.request.AddOrganRequestDto;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.request.AddOrganRequest;

import java.util.Collection;

public interface OrganMapper {

    AddOrganRequest toAddOrganRequest(AddOrganRequestDto organ);

    OrganDto toOrganDto(Organ organ);

    Collection<OrganDto> toOrganDtos(Collection<Organ> organs);
}
