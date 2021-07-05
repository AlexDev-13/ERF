package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.Subject;
import com.gov.erf.models.claims.request.AddSubjectRequest;
import com.gov.erf.repository.claim.SubjectRepository;
import com.gov.erf.service.claim.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class DefaultSubjectService implements SubjectService {

    private final SubjectRepository subjectRepository;

    public DefaultSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject get(Long id) {
        return subjectRepository.findById(id).orElseThrow();
    }

    @Override
    public Collection<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject create(AddSubjectRequest addSubjectRequest) {

        var subject = new Subject();
        subject.setTitle(addSubjectRequest.getTitle());

        return subjectRepository.save(subject);
    }
}
