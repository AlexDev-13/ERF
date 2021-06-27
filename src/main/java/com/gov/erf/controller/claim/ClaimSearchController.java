package com.gov.erf.controller.claim;


import com.gov.erf.config.predicate.builder.ClaimPage;
import com.gov.erf.config.predicate.criteria.ClaimSearchCriteria;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.service.claim.ClaimService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/claim/search")
public class ClaimSearchController {

    private final ClaimEndpoint claimEndpoint;
    private final ClaimService claimService;

    public ClaimSearchController(
            ClaimEndpoint claimEndpoint,
            ClaimService claimService) {
        this.claimEndpoint = claimEndpoint;
        this.claimService = claimService;
    }

    @GetMapping
    public Page<Claim> getClaims(ClaimPage claimPage,
                                    ClaimSearchCriteria claimSearchCriteria) {
        return claimService.getClaims(claimPage, claimSearchCriteria);
    }


}
