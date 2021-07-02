package com.gov.erf.repository.status;

import com.gov.erf.models.status.Status;
import com.gov.erf.models.status.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findByType(StatusType statusType);
}
