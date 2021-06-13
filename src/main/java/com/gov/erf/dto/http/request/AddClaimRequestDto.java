package com.gov.erf.dto.http.request;

import lombok.Data;

@Data
public class AddClaimRequestDto {

    private Long economicActivityId;
    private Long organId;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private Long regionId;
    private String empowerment;
}
