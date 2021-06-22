package com.gov.erf.controller;

import com.gov.erf.dto.http.inn.InnDto;
import com.gov.erf.endpoint.account.inn.InnEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/inn")
@RequestMapping
public class InnController {

    private final InnEndpoint innEndoint;

    public InnController(InnEndpoint innEndoint) {
        this.innEndoint = innEndoint;
    }

    @GetMapping
    public InnDto getInn(String inn) {
        return innEndoint.getInn(inn);
    }


}
