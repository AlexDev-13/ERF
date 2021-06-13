package com.gov.erf.endpoint.account.impl;

import com.gov.erf.dto.http.account.RegistrationRequestDto;
import com.gov.erf.endpoint.account.AccountEndpoint;
import com.gov.erf.service.account.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class DefaultAccountEndpoint implements AccountEndpoint {

    private final RegisterService registerService;

    public DefaultAccountEndpoint
            (
                    RegisterService registerService
            ) {
        this.registerService = registerService;
    }

    @Override
    public String register(RegistrationRequestDto registrationRequestDto) {
        return registerService.register(registrationRequestDto);
    }

    @Override
    public String confirmToken(String token) {
        return registerService.confirmToken(token);
    }
}
