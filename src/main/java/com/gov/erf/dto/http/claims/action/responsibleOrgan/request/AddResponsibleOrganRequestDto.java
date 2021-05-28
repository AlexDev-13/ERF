package com.gov.erf.dto.http.claims.action.responsibleOrgan.request;


import com.gov.erf.models.action.MovementActionType;
import lombok.Data;

@Data
public class AddResponsibleOrganRequestDto {

    private String title;
    private MovementActionType type;

}
