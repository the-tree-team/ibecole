package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.service.business.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.stream.Collectors;


public class PersonneRequestToParentConverter implements Converter<PersonneRequest, Parent> {


    private PersonneService personneService;

    @Autowired
    public PersonneRequestToParentConverter(PersonneService personneService) {
        this.personneService = personneService;
    }

    public PersonneRequestToParentConverter() {
       
    }
    @Nullable
    @Override
    public Parent convert(PersonneRequest personneRequest) {
        Parent parent= new Parent();

        /* Attributs Personne */
        parent.setNom(personneRequest.getNom());
        parent.setPrenom(personneRequest.getPrenom());
        parent.setSexe(Sexe.getSexeByLibelle(personneRequest.getSexe()));
        parent.setDateNaissance(personneRequest.getDateNaissance());
        parent.setLieuNaissance(personneRequest.getLieuNaissance());
        parent.setAdresse(personneRequest.getAdresse());
        parent.setTelephone(personneRequest.getTelephone());
        parent.setEmail(personneRequest.getEmail());/*
        parent.setPhoto(personneRequest.getPhoto());*/

        /* Attributs Parent */
        List<Eleve> enfantList = personneRequest.getEnfantList().stream().map( id ->
                (Eleve) personneService.findById(id,"Eleve")
        ).collect(Collectors.toList());
        parent.setEnfantList(enfantList);

        if(null != personneRequest.getId())
            parent.setId(personneRequest.getId());

        return parent;
    }
}
