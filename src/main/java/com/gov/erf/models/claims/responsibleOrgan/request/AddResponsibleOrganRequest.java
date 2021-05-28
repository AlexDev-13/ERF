package com.gov.erf.models.claims.responsibleOrgan.request;

import com.gov.erf.models.action.MovementActionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddResponsibleOrganRequest {

    private String title;
    private MovementActionType type;

}
