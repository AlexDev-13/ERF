package com.gov.erf.models.claims;

import com.gov.erf.config.basic.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "ref_region")
public class Region extends BaseEntity {

    @Column(name = "title")
    private String title;
}