package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.ApplicantDto;
import com.gov.erf.models.account.Applicant;

public interface ApplicantMapper {
    ApplicantDto toApplicantDto(Applicant applicant);
}
