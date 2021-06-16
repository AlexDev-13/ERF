package com.gov.erf.endpoint.account.impl;

import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.endpoint.account.AccountEndpoint;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.service.account.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class DefaultAccountEndpoint implements AccountEndpoint {

    private final RegisterService registerService;
    private final AccountMapper accountMapper;

    public DefaultAccountEndpoint
            (
                    RegisterService registerService,
                    AccountMapper accountMapper
            ) {
        this.registerService = registerService;
        this.accountMapper = accountMapper;
    }

    @Override
    public String register(AddUserRequestDto addUserRequestDto) {
        return registerService.register(addUserRequestDto);
    }

    @Override
    public String confirmToken(String token) {
        return registerService.confirmToken(token);
    }

}
