package com.gov.erf.dto.http.tables;

import com.gov.erf.dto.http.ClaimDto;
import com.gov.erf.models.action.MovementActionType;
import lombok.Data;


@Data
public class TableAuthorizedBodyDto {

    private ClaimDto claimId;
    private String cause;
    private MovementActionType decision;
}
