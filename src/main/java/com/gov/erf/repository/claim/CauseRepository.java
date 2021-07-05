package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.Cause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseRepository extends JpaRepository<Cause, Long> {
}
