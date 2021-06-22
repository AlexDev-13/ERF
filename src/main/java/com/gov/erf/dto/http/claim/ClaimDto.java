package com.gov.erf.dto.http.claim;


import com.gov.erf.dto.http.inn.InnDto;
import lombok.Data;

@Data
public class ClaimDto {

    private Long id;
    private ApplicantDto applicantType;
    private String fullname;
    private InnDto inn;
    private String telephone;
    private String email;
    private EconomicActivityDto economicActivity;
    private OrganDto organ;
    private String causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private RegionDto region;
    private String empowerment;

}
