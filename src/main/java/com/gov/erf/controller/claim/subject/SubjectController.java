package com.gov.erf.controller.claim.subject;

import com.gov.erf.dto.http.claim.SubjectDto;
import com.gov.erf.dto.http.claim.request.AddSubjectRequestDto;
import com.gov.erf.endpoint.claim.subject.SubjectEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectEndpoint subjectEndpoint;

    public SubjectController(SubjectEndpoint subjectEndpoint) {
        this.subjectEndpoint = subjectEndpoint;
    }

    @GetMapping("/get-all")
    public Collection<SubjectDto> getAll() {
        return subjectEndpoint.getAll();
    }

    @GetMapping("/get/{id}")
    public SubjectDto getAll(@PathVariable("id") Long id) {
        return subjectEndpoint.get(id);
    }

    @PostMapping
    public SubjectDto create(AddSubjectRequestDto addSubjectRequestDto) {
        return subjectEndpoint.create(addSubjectRequestDto);
    }

}
