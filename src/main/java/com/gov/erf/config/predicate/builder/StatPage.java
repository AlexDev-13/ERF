package com.gov.erf.config.predicate.builder;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.Date;

@Data
public class StatPage {

    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortByOrgan = "organ";
    private Date createdAt = new Date();

}
