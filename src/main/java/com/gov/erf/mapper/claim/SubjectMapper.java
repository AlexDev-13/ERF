package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claim.SubjectDto;
import com.gov.erf.dto.http.claim.request.AddSubjectRequestDto;
import com.gov.erf.models.claims.Subject;
import com.gov.erf.models.claims.request.AddSubjectRequest;

public interface SubjectMapper {

    SubjectDto toSubjectDto(Subject subject);
    AddSubjectRequest toAddSubjectRequest(AddSubjectRequestDto addSubjectRequestDto);
}
