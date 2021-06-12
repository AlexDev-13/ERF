package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByTitle(String region);
}
