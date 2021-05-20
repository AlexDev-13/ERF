package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.EconomicActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EconomicActivityRepository extends JpaRepository<EconomicActivity, Long> {
}
