package com.ibecole.ibecole.model.request;

import com.ibecole.ibecole.entity.business.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonneRequest {

    private Integer id;

    private String nom;

    private String prenom;

    private String sexe;

    private LocalDate dateNaissance;

    private String lieuNaissance;

    private String adresse;

    private String telephone;

    private String email;

    private byte[] photo;

    private boolean active;

    /* Eleve */
    private String matricule;

    private Parent parent;

    private List<Sanction> sanctionList;


    private List<Absence> absenceList;

    private List<EleveAppartenanceGroupe> eleveAppartenanceGroupeList;

    /* Parent */
    private List<Eleve> enfantList;

    /* Professeur */
    private LocalDate dateRecrutement;

    private List<Enseigner> enseigner;

    /* VIEW */

    private String type;
}
