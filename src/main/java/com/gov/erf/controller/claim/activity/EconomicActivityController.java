package com.gov.erf.controller.claim.activity;


import com.gov.erf.dto.http.claim.EconomicActivityDto;
import com.gov.erf.dto.http.claim.request.AddEconomicActivityRequestDto;
import com.gov.erf.endpoint.claim.activity.EconomicActivityEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/activity")
public class EconomicActivityController {


    private final EconomicActivityEndpoint economicActivityEndpoint;

    public EconomicActivityController(EconomicActivityEndpoint economicActivityEndpoint) {
        this.economicActivityEndpoint = economicActivityEndpoint;
    }

    @GetMapping("/get-all")
    public Collection<EconomicActivityDto> getAll() {
        return economicActivityEndpoint.getAll();
    }

    @GetMapping("/get/{id}")
    public EconomicActivityDto getById(@PathVariable("id") Long id) {
        return economicActivityEndpoint.get(id);
    }

    @PostMapping("/create")
    public EconomicActivityDto create(AddEconomicActivityRequestDto requestDto) {
        return economicActivityEndpoint.create(requestDto);
    }

}
