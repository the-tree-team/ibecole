package com.ibecole.ibecole.convertor;


import com.ibecole.ibecole.entity.business.Groupe;
import com.ibecole.ibecole.entity.business.Seance;
import com.ibecole.ibecole.model.request.GroupeRequest;
import com.ibecole.ibecole.model.request.SeanceRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class SeanceRequestToGroupeConverter implements Converter<SeanceRequest, Seance> {




    @Nullable
    @Override
    public Seance convert(SeanceRequest seanceRequest) {
        System.out.println("=========================================");
        Seance Seance= new Seance();
        Seance.setAbsences(seanceRequest.getAbsences());
        Seance.setClasse(seanceRequest.getClasse());
        Seance.setEnseigner(seanceRequest.getEnseigner());
        Seance.setGroupe(seanceRequest.getGroupe());
        Seance.setHeurDebut(seanceRequest.getHeurDebut());
        Seance.setHeurFin(seanceRequest.getHeurFin());
        Seance.setSupplementaire(seanceRequest.isSupplementaire());
        Seance.setSupplementairePayee(seanceRequest.isSupplementairePayee());
        Seance.setSeanceSpecialeList(seanceRequest.getSeanceSpecialeList());

        if(null != seanceRequest.getId())
            Seance.setId(seanceRequest.getId());

        return Seance;
    }
}
