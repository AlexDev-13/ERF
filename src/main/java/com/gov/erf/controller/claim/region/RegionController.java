package com.gov.erf.controller.claim.region;


import com.gov.erf.dto.http.claim.RegionDto;
import com.gov.erf.dto.http.claim.request.AddRegionRequestDto;
import com.gov.erf.endpoint.claim.region.RegionEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/region")
public class RegionController {

    private final RegionEndpoint regionEndpoint;

    public RegionController(RegionEndpoint regionEndpoint) {
        this.regionEndpoint = regionEndpoint;
    }

    @GetMapping("/get-all")
    public Collection<RegionDto> getAll(){
        return regionEndpoint.getAll();
    }

    @GetMapping("/get/{id}")
    public RegionDto get(@PathVariable("id") Long id){
        return regionEndpoint.getById(id);
    }

    @PostMapping("/create")
    public RegionDto create(AddRegionRequestDto requestDto){
        return regionEndpoint.create(requestDto);
    }
}
