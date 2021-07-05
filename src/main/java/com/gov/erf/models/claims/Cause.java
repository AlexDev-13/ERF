package com.gov.erf.models.claims;

import com.gov.erf.config.basic.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cause")
public class Cause extends BaseEntity {

    @Column(name = "title")
    private String title;

}
