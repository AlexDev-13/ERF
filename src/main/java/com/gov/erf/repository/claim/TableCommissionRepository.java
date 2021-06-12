package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.tables.TableCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableCommissionRepository extends JpaRepository<TableCommission, Long> {
}
