package com.gov.erf.repository.claim;


import com.gov.erf.models.claims.tables.ResponsibleBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleBodyRepository extends JpaRepository<ResponsibleBody, Long> {
}
