package com.gov.erf.mapper.inn;

import com.gov.erf.dto.http.inn.InnDto;
import com.gov.erf.models.inn.Inn;
import org.springframework.stereotype.Service;

@Service
public class DefaultInnMapper implements InnMapper{


    @Override
    public InnDto toInnDto(Inn inn) {

        var innDto = new InnDto();
        innDto.setInn(inn.getTitle());
        innDto.setCompanyName(inn.getCompanyName());

        return innDto;
    }
}
