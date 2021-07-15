package com.gov.erf.endpoint.claim.organ.impl;

import com.gov.erf.dto.http.claim.OrganDto;
import com.gov.erf.dto.http.claim.request.AddOrganRequestDto;
import com.gov.erf.endpoint.claim.organ.OrganEndpoint;
import com.gov.erf.mapper.claim.OrganMapper;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.request.AddOrganRequest;
import com.gov.erf.service.claim.OrganService;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class DefaultOrganEndpoint implements OrganEndpoint {

    private final OrganService organService;
    private final OrganMapper organMapper;

    public DefaultOrganEndpoint
            (
                    OrganService organService,
                    OrganMapper organMapper
            ) {
        this.organService = organService;
        this.organMapper = organMapper;
    }


    @Override
    public Collection<OrganDto> getAll() {

        Collection<Organ> organs = organService.getAll();
        return organMapper.toOrganDtos(organs);

    }

    @Override
    public OrganDto get(Long id) {

        Organ organ = organService.get(id);

        return organMapper.toOrganDto(organ);
    }

    @Override
    public OrganDto create(AddOrganRequestDto organRequestDto) {

        AddOrganRequest addOrganRequest = organMapper.toAddOrganRequest(organRequestDto);
        Organ organ = organService.create(addOrganRequest);

        return organMapper.toOrganDto(organ);
    }

    @Override
    public OrganDto delete(Long id) {
        Organ organ = organService.delete(id);

        return organMapper.toOrganDto(organ);

    }
}
