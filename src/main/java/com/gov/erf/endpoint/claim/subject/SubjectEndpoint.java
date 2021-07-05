package com.gov.erf.endpoint.claim.subject;

import com.gov.erf.dto.http.claim.SubjectDto;
import com.gov.erf.dto.http.claim.request.AddSubjectRequestDto;

import java.util.Collection;

public interface SubjectEndpoint {
    SubjectDto get(Long id);

    Collection<SubjectDto> getAll();

    SubjectDto create(AddSubjectRequestDto addSubjectRequestDto);
}
