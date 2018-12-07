package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Eleve")
public class Eleve extends Personne implements Serializable {

    @NotNull
    @Column(name = "matricule", length = 20, unique = true)
    private String matricule;

    @JoinTable(
            schema = StaticUtil.SCH_BUSINESS,
            name = "join_eleve_parent",
            joinColumns = @JoinColumn(name = "parent_fk"),
            inverseJoinColumns = @JoinColumn(name = "enfant_fk")
    )
    @ManyToOne
    private Parent parent;

    @OneToMany(mappedBy = "eleve")
    private List<Sanction> sanctionList;


    @OneToMany(
            mappedBy = "eleve",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EleveAppartenanceGroupe> eleveAppartenanceGroupeList;

}
