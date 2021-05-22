package com.gov.erf.models.claims;


import com.gov.erf.config.basic.MovableEntity;
import com.gov.erf.modules.models.AppFile;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "claims")
public class Claim extends MovableEntity {

    @NotNull
    @OneToOne
    @JoinColumn(name = "economic_activity_id")
    private EconomicActivity economicActivity;

    @NotNull
    @OneToOne
    @JoinColumn(name = "organ_addressed_id")
    private Organ organ;

    @Column(name = "cause_of_factor")
    private String causeOfFactor;

    @Column(name = "problem_of_description")
    private String problemOfDescription;

    @Column(name = "identification_factor")
    private String identificationFactor;

    @NotNull
    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "empowerment")
    private String empowerment;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private AppFile file;

}
