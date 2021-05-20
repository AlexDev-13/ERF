package com.gov.erf.models.claims.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddOrganRequest {

    private String title;
}
