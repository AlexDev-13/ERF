package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/claim/search")
public class ClaimSearchController {

    private final ClaimEndpoint claimEndpoint;

    public ClaimSearchController(
            ClaimEndpoint claimEndpoint
    ) {
        this.claimEndpoint = claimEndpoint;
    }

    @GetMapping
    public Collection<ClaimDto> search(@Param("region") String region) {
        return claimEndpoint.searchByParam(region);
    }

}
