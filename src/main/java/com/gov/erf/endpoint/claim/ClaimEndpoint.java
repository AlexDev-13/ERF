package com.gov.erf.endpoint.claim;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface ClaimEndpoint {

    ClaimDto create (AddClaimRequestDto addClaimRequestDto, MultipartFile file) throws Exception;

    ClaimDto getById(Long id);

    Collection<ClaimDto> getAll();
}
