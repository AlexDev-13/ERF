package com.gov.erf.modules.models;

import com.gov.erf.config.basic.AuditedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "files")
public class AppFile extends AuditedEntity {
    private String name;
    private String path;
}
