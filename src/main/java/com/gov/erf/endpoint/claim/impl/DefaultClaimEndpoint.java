package com.gov.erf.endpoint.claim.impl;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.mapper.claim.ClaimMapper;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.service.claim.ClaimService;
import org.springframework.stereotype.Service;

@Service
public class DefaultClaimEndpoint implements ClaimEndpoint {

    private final ClaimMapper claimMapper;
    private final ClaimService claimService;

    public DefaultClaimEndpoint
            (
                    ClaimMapper claimMapper,
                    ClaimService claimService
            ) {
        this.claimMapper = claimMapper;
        this.claimService = claimService;
    }


    @Override
    public ClaimDto create(AddClaimRequestDto addClaimRequestDto) {

        AddClaimRequest addClaimRequest = claimMapper.toClaimRequest(addClaimRequestDto);
        Claim claim = claimService.create(addClaimRequest);
        
        return claimMapper.toClaimDto(claim);
    }
}
