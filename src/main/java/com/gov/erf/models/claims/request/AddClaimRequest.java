package com.gov.erf.models.claims.request;


import com.gov.erf.models.account.Applicant;
import com.gov.erf.models.claims.*;
import com.gov.erf.models.inn.Inn;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddClaimRequest {

    private Applicant applicantType;
    private String fullname;
    private String inn;
    private String telephone;
    private Subject subjectType;
    private String email;
    private String companyName;
    private EconomicActivity economicActivity;
    private Organ organ;
    private Cause causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private Region region;
    private String empowerment;
    private Boolean agreement;
}
