package com.gov.erf.repository.claim.action;

import com.gov.erf.models.claims.responsibleOrgan.ResponsibleOrgan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleOrganRepository extends JpaRepository<ResponsibleOrgan,Long> {
}
