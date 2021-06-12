package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;

import java.util.Collection;

public interface ClaimMapper {
    AddClaimRequest toClaimRequest(AddClaimRequestDto addClaimRequestDto);
    ClaimDto toClaimDto(Claim claim);
    Collection<ClaimDto> toClaimDtos(Collection<Claim> claims);
}
