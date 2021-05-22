package com.gov.erf.config.basic;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.point.MovementPoint;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class MovableEntity extends AuditedEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "point_id")
    private MovementPoint point;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "action_id")
    private MovementAction action;

}