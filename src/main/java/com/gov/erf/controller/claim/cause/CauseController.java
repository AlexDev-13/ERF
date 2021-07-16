package com.gov.erf.controller.claim.cause;


import com.gov.erf.dto.http.claim.CauseDto;
import com.gov.erf.dto.http.claim.request.AddCauseOfFactorRequestDto;
import com.gov.erf.endpoint.claim.cause.CauseEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/cause")
public class CauseController {

    private final CauseEndpoint causeOfFactorEndpoint;

    public CauseController(CauseEndpoint causeOfFactorEndpoint) {
        this.causeOfFactorEndpoint = causeOfFactorEndpoint;
    }

    @GetMapping("/get-all")
    public Collection<CauseDto> getAll(){
        return causeOfFactorEndpoint.getAll();
    }

    @GetMapping("/get/{id}")
    public CauseDto getAll(@PathVariable("id") Long id){
        return causeOfFactorEndpoint.get(id);
    }

    @PostMapping
    public CauseDto create (@RequestBody AddCauseOfFactorRequestDto addCauseOfFactorRequestDto){
        return causeOfFactorEndpoint.create(addCauseOfFactorRequestDto);
    }
}
