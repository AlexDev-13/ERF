package com.gov.erf.models.claims.request;


import com.gov.erf.models.account.Applicant;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.inn.Inn;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddClaimRequest {

    private Applicant applicantType;
    private String fullname;
    private Inn inn;
    private String telephone;
    private String email;
    private EconomicActivity economicActivity;
    private Organ organ;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private Region region;
    private String empowerment;
}
