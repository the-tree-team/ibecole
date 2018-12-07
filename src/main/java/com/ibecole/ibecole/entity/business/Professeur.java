package com.ibecole.ibecole.entity.business;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Professeur")
public class Professeur extends Personne implements Serializable {

    @Column(name = "date_recrutement")
    private LocalDate dateRecrutement;
}
