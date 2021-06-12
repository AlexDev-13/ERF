package com.gov.erf.dto.http.claims.request;


import lombok.Data;

@Data
public class SearchClaimsByParam {

    private Long regionId;
    private Long organId;
    private Long economicActivityId;


}
