package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    Page<Claim> findAll(Pageable pageable);

    Collection<Claim> findAllByRegion(Region region);
}
