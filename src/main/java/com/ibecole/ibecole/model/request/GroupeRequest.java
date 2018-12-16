package com.ibecole.ibecole.model.request;

import com.ibecole.ibecole.entity.business.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GroupeRequest {

    private Integer id;
    private String code;
    private Integer nombeMaxEleve;
    private Periode periodeActuelle;
    private List<Periode> periodeList;
    private List<EleveAppartenanceGroupe> eleveAppartenanceGroupeList;
    private Niveau niveau ;
    private Formation formation;
}
