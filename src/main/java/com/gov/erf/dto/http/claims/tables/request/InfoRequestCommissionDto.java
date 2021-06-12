package com.gov.erf.dto.http.claims.tables.request;


import lombok.Builder;
import lombok.Data;

@Data
public class InfoRequestCommissionDto {
    private Long claimId;
    private String cause;
    private Boolean decision;
}
