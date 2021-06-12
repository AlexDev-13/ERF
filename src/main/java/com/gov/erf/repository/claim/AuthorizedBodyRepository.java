package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.tables.AuthorizedBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizedBodyRepository extends JpaRepository<AuthorizedBody,Long> {
}
