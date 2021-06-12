package com.gov.erf.models.claims.tables.request;


import com.gov.erf.models.claims.Claim;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsibleBodyRequest {

    private Claim claim;
    private String cause;
    private Boolean decision;

}
