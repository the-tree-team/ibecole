package com.ibecole.ibecole.entity.business;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Professeur")
@Getter
@Setter
public class Professeur extends Personne implements Serializable {

    @Column(name = "date_recrutement")
    private LocalDate dateRecrutement;
}
