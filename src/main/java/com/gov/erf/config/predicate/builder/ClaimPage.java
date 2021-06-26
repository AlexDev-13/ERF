package com.gov.erf.config.predicate.builder;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class ClaimPage {

    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "region";

}
