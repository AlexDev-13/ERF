package com.gov.erf.dto.http.request;

import com.gov.erf.dto.http.claim.ApplicantType;
import lombok.Data;

@Data
public class AddClaimRequestDto {


    private Long applicantType;
    private String fullname;
    private String inn;
    private String telephone;
    private String email;
    private Long economicActivityId;
    private Long organId;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private Long regionId;
    private String empowerment;
}
