package com.ibecole.ibecole.convertor;


import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;


public class PersonneRequestToEleveConverter implements Converter<PersonneRequest, Eleve> {




    @Nullable
    @Override
    public Eleve convert(PersonneRequest personneRequest) {
        System.out.println("=========================================");
        System.out.println(Sexe.getSexeByLibelle(personneRequest.getSexe()));
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
