package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.CauseDto;
import com.gov.erf.dto.http.claim.request.AddCauseOfFactorRequestDto;
import com.gov.erf.mapper.claim.CauseMapper;
import com.gov.erf.models.claims.Cause;
import com.gov.erf.models.claims.request.AddCauseRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultCauseMapper implements CauseMapper {



    @Override
    public CauseDto toCauseDto(Cause cause) {

        var causeDto = new CauseDto();

        causeDto.setId(cause.getId());
        causeDto.setTitle(cause.getTitle());

        return causeDto;
    }

    @Override
    public AddCauseRequest toAddCouseRequest(AddCauseOfFactorRequestDto addCauseOfFactorRequestDto) {
        return AddCauseRequest.builder()
                .title(addCauseOfFactorRequestDto.getTitle())
                .build();
    }
}
