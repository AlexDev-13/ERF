package com.gov.erf.models.roadmap;

import com.gov.erf.config.basic.BaseEntity;
import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.point.MovementPoint;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Entity
@Table(name = "movement_roadmaps")
public class MovementRoadmap extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "source_point_id")
    private MovementPoint sourcePoint;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "action_id")
    private MovementAction action;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "target_point_id")
    private MovementPoint targetPoint;
}
