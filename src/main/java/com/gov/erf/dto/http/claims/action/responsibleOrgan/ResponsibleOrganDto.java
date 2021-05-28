package com.gov.erf.dto.http.claims.action.responsibleOrgan;

import com.gov.erf.models.action.MovementActionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsibleOrganDto {

    private Long id;
    private String title;
    private MovementActionType type;

}
