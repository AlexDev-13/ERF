package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.OrganDto;
import com.gov.erf.mapper.claim.OrganMapper;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.request.AddOrganRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrganMapper implements OrganMapper {


    @Override
    public AddOrganRequest toAddOrganRequest(OrganDto organ) {
        return AddOrganRequest
                .builder()
                .title(organ.getTitle())
                .build();
    }

    @Override
    public OrganDto toOrganDto(Organ organ) {

        var organDto = new OrganDto();

        organDto.setId(organ.getId());
        organDto.setTitle(organ.getTitle());

        return organDto;
    }
}
