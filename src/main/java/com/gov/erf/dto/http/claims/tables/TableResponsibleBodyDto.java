package com.gov.erf.dto.http.claims.tables;


import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.models.action.MovementActionType;
import lombok.Data;

@Data
public class TableResponsibleBodyDto {

    private ClaimDto claimId;
    private String cause;
    private MovementActionType decision;

}
