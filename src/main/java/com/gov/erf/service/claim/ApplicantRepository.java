package com.gov.erf.service.claim;

import com.gov.erf.models.account.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    Applicant findByTitle(String title);
}
