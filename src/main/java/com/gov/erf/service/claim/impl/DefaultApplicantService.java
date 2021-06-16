package com.gov.erf.service.claim.impl;

import com.gov.erf.models.account.Applicant;
import com.gov.erf.service.claim.ApplicantRepository;
import com.gov.erf.service.claim.ApplicantService;
import org.springframework.stereotype.Service;

@Service
public class DefaultApplicantService implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    public DefaultApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public Applicant findByTitle(String title) {
        return applicantRepository.findByTitle(title);
    }

    @Override
    public Applicant get(Long id) {
        return applicantRepository.findById(id).orElseThrow();
    }
}
