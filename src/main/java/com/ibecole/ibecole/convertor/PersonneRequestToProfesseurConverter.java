package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;


public class PersonneRequestToProfesseurConverter implements Converter<PersonneRequest, Professeur> {


    @Nullable
    @Override
    public Professeur convert(PersonneRequest personneRequest) {
        Professeur professeur = new Professeur();
        professeur.setNom(personneRequest.getNom());
        professeur.setPrenom(personneRequest.getPrenom());
        professeur.setSexe(Sexe.getSexeByLibelle(personneRequest.getSexe()));
        professeur.setDateNaissance(personneRequest.getDateNaissance());
        professeur.setLieuNaissance(personneRequest.getLieuNaissance());
        professeur.setAdresse(personneRequest.getAdresse());
        professeur.setTelephone(personneRequest.getTelephone());
        professeur.setEmail(personneRequest.getEmail());
        professeur.setPhoto(personneRequest.getPhoto());
          /* Attributs Professeur */
        professeur.setDateRecrutement(personneRequest.getDateRecrutement());
        professeur.setEnseigner(personneRequest.getEnseigner());

        if(null != personneRequest.getId())
            professeur.setId(personneRequest.getId());

        return professeur;
    }
}
