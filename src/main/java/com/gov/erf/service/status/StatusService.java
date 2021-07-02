package com.gov.erf.service.status;

import com.gov.erf.models.status.Status;
import com.gov.erf.models.status.StatusType;

public interface StatusService {
    Status get(StatusType statusType);
}
