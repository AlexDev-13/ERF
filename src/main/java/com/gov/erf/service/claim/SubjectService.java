package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Subject;
import com.gov.erf.models.claims.request.AddSubjectRequest;

import java.util.Collection;

public interface SubjectService {

    Subject get(Long id);

    Collection<Subject> getAll();

    Subject create(AddSubjectRequest addSubjectRequest);

}
