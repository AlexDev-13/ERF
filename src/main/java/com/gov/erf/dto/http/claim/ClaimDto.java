package com.gov.erf.dto.http.claim;


import lombok.Data;

@Data
public class ClaimDto {

    private Long id;
    private ApplicantDto applicantType;
    private String fullname;
    private String inn;
    private String telephone;
    private String email;
    private String companyName;
    private SubjectDto subjectType;
    private EconomicActivityDto economicActivity;
    private OrganDto organ;
    private CauseDto causeOfFactor;
    private String problemOfDescription;
    private String identificationFactor;
    private RegionDto region;
    private String empowerment;
    private String status;

}
