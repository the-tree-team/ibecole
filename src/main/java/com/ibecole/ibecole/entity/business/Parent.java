package com.ibecole.ibecole.entity.business;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Parent")

@Getter
@Setter
public class Parent extends Personne implements Serializable {


    @OneToMany(mappedBy = "parent")
    private List<Eleve> enfantList;
}
