package com.gov.erf.endpoint.claim.organ;

import com.gov.erf.dto.http.claim.OrganDto;
import com.gov.erf.dto.http.claim.request.AddOrganRequestDto;

import java.util.Collection;

public interface OrganEndpoint {

    Collection<OrganDto> getAll();
    OrganDto get(Long id);
    OrganDto create(AddOrganRequestDto organRequestDto);
    OrganDto delete(Long id);
}
