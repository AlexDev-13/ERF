package com.gov.erf.service.claim;

import com.gov.erf.models.account.Applicant;

public interface ApplicantService {

    Applicant findByTitle(String title);
    Applicant get(Long id);

}
