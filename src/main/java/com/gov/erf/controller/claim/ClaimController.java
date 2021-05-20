package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/claim")
public class ClaimController {

    private final ClaimEndpoint claimEndpoint;

    public ClaimController
            (
                    ClaimEndpoint claimEndpoint
            ) {
        this.claimEndpoint = claimEndpoint;
    }

    @PostMapping("/create")
    ClaimDto create(@RequestBody AddClaimRequestDto addClaimRequestDto) {
       return claimEndpoint.create(addClaimRequestDto);
    }

}
