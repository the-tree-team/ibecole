package com.ibecole.ibecole.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AbsenceRequest {

    private Integer idAbsence;
    private Integer idJustificatif;

    /* Absence */
    private LocalDate dateAbsence;
    private Integer  idSeance;
    private Integer idEleve;

    /* Justificatif */
    private String codeJustificatif;
    private String libelleJustificatif;
}
