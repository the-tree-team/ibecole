package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.util.function.Function;

public class PersonneRequestToParentConverter implements Converter<PersonneRequest, Parent> {


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
        parent.setEmail(personneRequest.getEmail());
        parent.setPhoto(personneRequest.getPhoto());

        /* Attributs Parent */
        parent.setEnfantList(personneRequest.getEnfantList());

        if(null != personneRequest.getId())
            parent.setId(personneRequest.getId());

        return parent;
    }
}
