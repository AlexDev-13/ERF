package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.ApplicantDto;
import com.gov.erf.mapper.claim.ApplicantMapper;
import com.gov.erf.models.account.Applicant;
import org.springframework.stereotype.Service;

@Service
public class DefaultApplicantMapper implements ApplicantMapper {


    @Override
    public ApplicantDto toApplicantDto(Applicant applicant) {

        var applicantDto = new ApplicantDto();

        applicantDto.setTitle(applicant.getTitle());

        return applicantDto;
    }
}
