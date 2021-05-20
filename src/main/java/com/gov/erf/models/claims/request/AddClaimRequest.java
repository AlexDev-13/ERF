package com.gov.erf.models.claims.request;


import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.Region;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddClaimRequest {
    private EconomicActivity economicActivity;
    private Organ organ;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private Region region;
    private String empowerment;
}
