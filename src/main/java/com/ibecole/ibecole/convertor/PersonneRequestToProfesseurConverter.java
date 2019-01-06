package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Enseigner;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;


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
        if(personneRequest.getPhoto()!=null) {
            try {
                professeur.setPhoto(personneRequest.getPhoto().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
          /* Attributs Professeur */
        professeur.setDateRecrutement(personneRequest.getDateRecrutement());

        /**- IL FAUT PERSISTER LA LISTE ENSEIGNER A PART, CAR ON N'A PAS FORCEMENT L'ID DU PROFESSEUR,
         * SI ON NE L'A PAS ENCORE PERSISTé DANS LA BDD.
         * - IL NOUS FAUT DONC UNE "ENSEIGNER FACTORY" QUI RECOIT UNE LISTE DE MATIERES ET l'ID D'UN PROFESSEUR,
         * ET PERSISTE LE TOUT !
         * **/
       // professeur.setEnseigner(personneRequest.getEnseigner());

        if(null != personneRequest.getId()) {
            professeur.setId(personneRequest.getId());
        }

        return professeur;
    }
}
