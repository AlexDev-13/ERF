package com.gov.erf.models.action;


import com.gov.erf.config.basic.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "movement_actions")
public class MovementAction extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private MovementActionType type;
}
