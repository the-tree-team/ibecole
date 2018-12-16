package com.ibecole.ibecole.model.request;

import com.ibecole.ibecole.entity.business.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class SeanceRequest {
    private Integer id;
    private LocalTime heurDebut;
    private LocalTime heurFin;

    private boolean supplementaire;

    private boolean supplementairePayee;

    private Groupe groupe;

    private Enseigner enseigner;

    private Classe classe;

    private List<Absence> absences;

    private List<SeanceSpeciale> seanceSpecialeList;
}
