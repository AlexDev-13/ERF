package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.SubjectDto;
import com.gov.erf.dto.http.claim.request.AddSubjectRequestDto;
import com.gov.erf.mapper.claim.SubjectMapper;
import com.gov.erf.models.claims.Subject;
import com.gov.erf.models.claims.request.AddSubjectRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectMapper implements SubjectMapper {


    @Override
    public SubjectDto toSubjectDto(Subject subject) {

        var subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setTitle(subject.getTitle());
        return subjectDto;
    }

    @Override
    public AddSubjectRequest toAddSubjectRequest(AddSubjectRequestDto addSubjectRequestDto) {
        return AddSubjectRequest.builder()
                .title(addSubjectRequestDto.getTitle())
                .build();
    }
}
