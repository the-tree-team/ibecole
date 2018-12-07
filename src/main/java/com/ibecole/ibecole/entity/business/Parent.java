package com.ibecole.ibecole.entity.business;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Parent")
public class Parent extends Personne implements Serializable {


    @OneToMany(mappedBy = "parent")
    private List<Eleve> enfantList;
}
