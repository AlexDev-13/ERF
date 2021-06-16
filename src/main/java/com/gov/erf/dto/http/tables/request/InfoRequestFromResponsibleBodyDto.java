package com.gov.erf.dto.http.tables.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoRequestFromResponsibleBodyDto {

    private Long claimId;
    private String cause;
    private Boolean decision;

}
