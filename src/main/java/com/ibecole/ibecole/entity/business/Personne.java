package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.commun.enumerate.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 15)
@Table(schema = StaticUtil.SCH_BUSINESS, name = "personne")
public abstract class Personne  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nom", length = 30, nullable = false)
    private String nom;

    @NotNull
    @Column(name = "prenom", length = 30, nullable = false)
    private String prenom;

    @NotNull
    @Column(name = "sexe", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "lieu_naissance", length = 50)
    private String lieuNaissance;

    @NotNull
    @Column(name = "adresse", length = 150, nullable = false)
    private String adresse;

    @NotNull
    @Column(name = "telephone", length = 15, nullable = false)
    private String telephone;

    @Column(name = "email", length = 30)
    private String email;

    private boolean active;
}
