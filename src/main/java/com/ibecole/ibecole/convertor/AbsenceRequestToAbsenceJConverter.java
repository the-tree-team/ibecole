package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.entity.business.Absence;
import com.ibecole.ibecole.entity.business.Justificatif;
import com.ibecole.ibecole.model.request.AbsenceRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class AbsenceRequestToAbsenceJConverter implements Converter<AbsenceRequest, Absence> {
    @Nullable
    @Override
    public Absence convert(AbsenceRequest absenceRequest) {
        Absence absence = new Absence();
        Justificatif justificatif = new Justificatif();

        absence.setDate(absenceRequest.getDateAbsence());

        justificatif.setCode(absenceRequest.getCodeJustificatif());
        justificatif.setLibelle(absenceRequest.getLibelleJustificatif());

        if(absenceRequest.getIdAbsence()!=null){
            absence.setId(absenceRequest.getIdAbsence());
        }

        if(absenceRequest.getIdJustificatif()!=null){
            justificatif.setId(absenceRequest.getIdJustificatif());
        }

        absence.setJustificatif(justificatif);
        return absence;
    }
}
