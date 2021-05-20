package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganRepository extends JpaRepository<Organ,Long> {
}
