package com.gov.erf.controller.inn;

import com.gov.erf.dto.http.inn.InnDto;
import com.gov.erf.endpoint.account.inn.InnEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/inn")
@RequestMapping
public class InnController {

    private final InnEndpoint innEndpoint;

    public InnController(InnEndpoint innEndpoint) {
        this.innEndpoint = innEndpoint;
    }

    @GetMapping("/get/{code}")
    public InnDto getInn(@PathVariable("code") String inn) throws Exception {
        return innEndpoint.getInn(inn);
    }


}
