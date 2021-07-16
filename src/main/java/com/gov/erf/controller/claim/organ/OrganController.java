package com.gov.erf.controller.claim.organ;

import com.gov.erf.dto.http.claim.OrganDto;
import com.gov.erf.dto.http.claim.request.AddOrganRequestDto;
import com.gov.erf.endpoint.claim.organ.OrganEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/organ")
public class OrganController {

    private final OrganEndpoint organEndpoint;

    public OrganController(OrganEndpoint organEndpoint) {
        this.organEndpoint = organEndpoint;
    }

    @GetMapping("/get-all")
    public Collection<OrganDto> getAll() {
        return organEndpoint.getAll();
    }

    @GetMapping("/get/{id}")
    public OrganDto getById(@PathVariable("id") Long id) {
        return organEndpoint.get(id);
    }

    @PostMapping("/create")
    public OrganDto create(@RequestBody AddOrganRequestDto addOrganRequestDto) {
        return organEndpoint.create(addOrganRequestDto);
    }

    @PostMapping("/delete/{id}")
    public OrganDto deleteById(@PathVariable("id") Long id){
        return organEndpoint.delete(id);
    }

}
