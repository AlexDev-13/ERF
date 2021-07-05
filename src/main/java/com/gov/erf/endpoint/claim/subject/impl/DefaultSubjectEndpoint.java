package com.gov.erf.endpoint.claim.subject.impl;

import com.gov.erf.dto.http.claim.SubjectDto;
import com.gov.erf.dto.http.claim.request.AddSubjectRequestDto;
import com.gov.erf.endpoint.claim.subject.SubjectEndpoint;
import com.gov.erf.mapper.claim.SubjectMapper;
import com.gov.erf.models.claims.Subject;
import com.gov.erf.models.claims.request.AddSubjectRequest;
import com.gov.erf.service.claim.SubjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DefaultSubjectEndpoint implements SubjectEndpoint {

    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    public DefaultSubjectEndpoint(SubjectService subjectService, SubjectMapper subjectMapper) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectDto get(Long id) {

        Subject subject = subjectService.get(id);

        return subjectMapper.toSubjectDto(subject);
    }

    @Override
    public Collection<SubjectDto> getAll() {

        Collection<Subject> subjects = subjectService.getAll();
        Collection<SubjectDto> subjectDtos = new ArrayList<>();

        for (Subject subject : subjects) {
            subjectDtos.add(subjectMapper.toSubjectDto(subject));
        }
        return subjectDtos;
    }

    @Override
    public SubjectDto create(AddSubjectRequestDto addSubjectRequestDto) {

        AddSubjectRequest addSubjectRequest = subjectMapper.toAddSubjectRequest(addSubjectRequestDto);

        Subject subject = subjectService.create(addSubjectRequest);

        return subjectMapper.toSubjectDto(subject);
    }
}
