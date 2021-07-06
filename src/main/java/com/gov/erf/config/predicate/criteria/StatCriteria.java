package com.gov.erf.config.predicate.criteria;

import com.gov.erf.models.claims.Organ;
import lombok.Data;

import java.util.Date;

@Data
public class StatCriteria {

    private Date createdAt;
    private Organ organ;
}
