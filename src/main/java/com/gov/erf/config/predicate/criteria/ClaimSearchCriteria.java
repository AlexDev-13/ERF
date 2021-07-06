package com.gov.erf.config.predicate.criteria;

import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.status.Status;
import lombok.Data;

@Data
public class ClaimSearchCriteria {

    private Region region;
    private Organ organ;
    private String companyName;
    private String inn;
    private String fullname;
    private Status status;
    private EconomicActivity economicActivity;
    private String identificationFactor;
}
