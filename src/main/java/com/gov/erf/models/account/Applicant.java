package com.gov.erf.models.account;

import com.gov.erf.config.basic.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "applicant")
public class Applicant extends BaseEntity {

    @Column(name = "title")
    private String title;
}
