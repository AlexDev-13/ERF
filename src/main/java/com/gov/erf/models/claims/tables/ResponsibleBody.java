package com.gov.erf.models.claims.tables;


import com.gov.erf.config.basic.BaseEntity;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Claim;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "responsible_body_claims")
public class ResponsibleBody extends BaseEntity {

    @OneToOne
    @NotNull
    @JoinColumn(name = "claim_id")
    private Claim claim;

    @Column(name = "cause")
    private String cause;

    @Column(name = "decision")
    @Enumerated(value = EnumType.STRING)
    private MovementActionType decision;

}
