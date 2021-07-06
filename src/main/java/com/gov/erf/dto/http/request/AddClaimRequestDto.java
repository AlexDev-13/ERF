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
    private Long subjectTypeId;
    private Long economicActivityId;
    private Long organId;
    private Long causeOfFactor;
    private String problemOfDescription;
    private String descriptionDate;
    private Long regionId;
    private String clarification;
    private boolean agreement;
}
