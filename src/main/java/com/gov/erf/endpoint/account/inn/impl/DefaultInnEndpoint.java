package com.gov.erf.endpoint.account.inn.impl;

import com.gov.erf.dto.http.inn.InnDto;
import com.gov.erf.endpoint.account.inn.InnEndpoint;
import com.gov.erf.mapper.inn.InnMapper;
import com.gov.erf.models.inn.Inn;
import com.gov.erf.service.inn.InnService;
import org.springframework.stereotype.Service;

@Service
public class DefaultInnEndpoint implements InnEndpoint {

    private final InnService innService;
    private final InnMapper innMapper;

    public DefaultInnEndpoint(InnService innService, InnMapper innMapper) {
        this.innService = innService;
        this.innMapper = innMapper;
    }

    @Override
    public InnDto getInn(String inn) {
        Inn innEntity =  innService.getInn(inn);

        return innMapper.toInnDto(innEntity);
    }
}
