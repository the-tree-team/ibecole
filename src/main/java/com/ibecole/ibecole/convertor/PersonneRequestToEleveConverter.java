package com.ibecole.ibecole.convertor;


import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.service.business.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class PersonneRequestToEleveConverter implements Converter<PersonneRequest, Eleve> {


    private PersonneService personneService;
    private ConversionService conversionService;

    @Autowired
    public PersonneRequestToEleveConverter(PersonneService personneService, ConversionService conversionService) {
        this.personneService = personneService;
        this.conversionService = conversionService;
    }

    public PersonneRequestToEleveConverter() {

    }

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
        if(personneRequest.getPhoto()!=null){
            try {
                eleve.setPhoto(personneRequest.getPhoto().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* Attributs Eleve */
        /** Pas besoin du matricule parcequ'on le crée nous même avant de persister **/
//        eleve.setMatricule(personneRequest.getMatricule());

//        eleve.setSanctionList(personneRequest.getSanctionList());
//        eleve.setAbsenceList(personneRequest.getAbsenceList());
        /** Doit être supprimée car on n'affecte pas les groupes dans la création de l'élève, mais on affecte les élèves
         * au groupe, et donc ça doit être placé dans le groupe
         */
        //eleve.setEleveAppartenanceGroupeList(personneRequest.getEleveAppartenanceGroupeList());

        if(null != personneRequest.getId())
            eleve.setId(personneRequest.getId());
/*

        if(null != personneRequest.getIdParent())
            eleve.setParent( (Parent) personneService.findById(personneRequest.getIdParent(),"Parent"));
*/
       if(personneRequest.getParent()!=null){
           /*eleve.setParent(personneRequest.getParent());*/
        }
        return eleve;
    }
}
