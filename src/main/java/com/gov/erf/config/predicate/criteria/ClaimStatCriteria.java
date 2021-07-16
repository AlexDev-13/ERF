package com.gov.erf.config.predicate.criteria;

import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Region;
import lombok.Data;

@Data
public class ClaimStatCriteria {

    private Region region;
    private EconomicActivity economicActivity;

}
