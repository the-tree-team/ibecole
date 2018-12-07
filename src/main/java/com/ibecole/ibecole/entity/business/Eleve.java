package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.enumerate.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
}
