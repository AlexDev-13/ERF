package com.gov.erf.models.claims.responsibleOrgan;


import com.gov.erf.config.basic.AuditedEntity;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Claim;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "claim_action_responsible_organ")
public class ResponsibleOrgan extends AuditedEntity {


    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "type", updatable = false)
    @Enumerated(value = EnumType.STRING)
    private MovementActionType type;
}
