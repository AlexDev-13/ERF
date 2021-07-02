package com.gov.erf.models.status;

import com.gov.erf.config.basic.BaseEntity;
import com.gov.erf.models.point.MovementPointType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "status")
public class Status extends BaseEntity {

    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private StatusType type;

}
