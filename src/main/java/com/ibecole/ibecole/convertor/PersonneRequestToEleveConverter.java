package com.ibecole.ibecole.convertor;


import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.model.request.PersonneRequest;

import java.util.function.Function;

public class PersonneRequestToEleveConverter implements Function<PersonneRequest, Eleve> {


    @Override
    public Eleve apply(PersonneRequest personneRequest) {
        Eleve eleve = new Eleve();

        /* Attributs Personne */
        eleve.setNom(personneRequest.getNom());
        eleve.setPrenom(personneRequest.getPrenom());
        eleve.setSexe(Sexe.getSexeByLibelle(personneRequest.getSexe()));
        eleve.setDateNaissance(personneRequest.getDateNaissance());
        eleve.setLieuNaissance(personneRequest.getLieuNaissance());
        eleve.setAdresse(personneRequest.getAdresse());
        eleve.setTelephone(personneRequest.getTelephone());
        eleve.setEmail(personneRequest.getEmail());
        eleve.setPhoto(personneRequest.getPhoto());

        /* Attributs Eleve */
        eleve.setMatricule(personneRequest.getMatricule());
        eleve.setParent(personneRequest.getParent());
        eleve.setSanctionList(personneRequest.getSanctionList());
        eleve.setAbsenceList(personneRequest.getAbsenceList());
        eleve.setEleveAppartenanceGroupeList(personneRequest.getEleveAppartenanceGroupeList());

        if(null != personneRequest.getId())
            eleve.setId(personneRequest.getId());

        return eleve;
    }
}
