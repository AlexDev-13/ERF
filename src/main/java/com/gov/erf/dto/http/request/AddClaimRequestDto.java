package com.gov.erf.dto.http.request;

import lombok.Data;

@Data
public class AddClaimRequestDto {


    private Long applicantType;
    private String fullname;
    private String inn;
    private String telephone;
    private String email;
    private String companyName;
    private Long economicActivityId;
    private Long organId;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private Long regionId;
    private String empowerment;
    private boolean agreement;
}
