package com.gov.erf.dto.http.claims;


import lombok.Data;

@Data
public class ClaimDto {

    private Long id;
    private EconomicActivityDto economicActivity;
    private OrganDto organ;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private RegionDto region;
    private String empowerment;

}
