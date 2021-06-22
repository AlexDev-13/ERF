package com.gov.erf.models.inn;


import com.gov.erf.config.basic.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "inn")
public class Inn extends BaseEntity {

    @Column(name = "inn")
    private String inn;

    @Column(name = "name")
    private String companyName;

}
