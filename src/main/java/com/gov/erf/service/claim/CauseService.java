package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Cause;
import com.gov.erf.models.claims.request.AddCauseRequest;

import java.util.Collection;

public interface CauseService {

    Cause get(Long id);

    Collection<Cause> getAll();

    Cause create(AddCauseRequest addCauseRequest);
}
