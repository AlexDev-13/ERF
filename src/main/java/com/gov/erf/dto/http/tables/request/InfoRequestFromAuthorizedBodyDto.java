package com.gov.erf.dto.http.tables.request;


import lombok.Data;

@Data
public class InfoRequestFromAuthorizedBodyDto {
    private Long claimId;
    private String cause;
    private Boolean decision;
}
