package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.model.request.PersonneRequest;

import java.util.function.Function;

public class PersonneRequestToProfesseurConverter implements Function<PersonneRequest, Professeur> {
    @Override
    public Professeur apply(PersonneRequest personneRequest) {
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
         return professeur;

    }

}
