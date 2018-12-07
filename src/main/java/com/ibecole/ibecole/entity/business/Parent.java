package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.enumerate.StaticUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Parent")
public class Parent extends Personne implements Serializable {


    @OneToMany(mappedBy = "parent")
    private List<Eleve> enfants;
}
