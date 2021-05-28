package com.gov.erf.mapper.claim.action.impl;

import com.gov.erf.dto.http.claims.action.responsibleOrgan.ResponsibleOrganDto;
import com.gov.erf.dto.http.claims.action.responsibleOrgan.request.AddResponsibleOrganRequestDto;
import com.gov.erf.mapper.claim.action.ResponsibleOrganMapper;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.responsibleOrgan.ResponsibleOrgan;
import com.gov.erf.models.claims.responsibleOrgan.request.AddResponsibleOrganRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultResponsibleOrganMapper implements ResponsibleOrganMapper {

    @Override
    @Transactional(readOnly = true)
    public AddResponsibleOrganRequest toAddResponsibleOrganRequest
            (
                    AddResponsibleOrganRequestDto requestDto,
                    MovementActionType type
            ) {
        return AddResponsibleOrganRequest
                .builder()
                .title(requestDto.getTitle())
                .type(type)
                .build();
    }


    @Override
    @Transactional(readOnly = true)
    public ResponsibleOrganDto toAcceptResponsibleOrganDto(ResponsibleOrgan organ) {
        return ResponsibleOrganDto
                .builder()
                .id(organ.getId())
                .title(organ.getTitle())
                .type(organ.getType())
                .build();
    }
}
