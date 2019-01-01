package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.model.response.PersonneResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class EleveToPersonneResponseConverter implements Converter<Eleve, PersonneResponse> {
    @Nullable
    @Override
    public PersonneResponse convert(Eleve eleve) {
        PersonneResponse personneResponse = new PersonneResponse();
        personneResponse.setNom(eleve.getNom());
        personneResponse.setPrenom(eleve.getPrenom());
        personneResponse.setSexe(eleve.getSexe().getLibelle());
        personneResponse.setDateNaissance(eleve.getDateNaissance());
        personneResponse.setLieuNaissance(eleve.getLieuNaissance());
        personneResponse.setAdresse(eleve.getAdresse());
        personneResponse.setTelephone(eleve.getTelephone());
        personneResponse.setEmail(eleve.getEmail());/*
        personneResponse.setPhoto(eleve.getPhoto());*/

        /*** Eleve **/
       /* personneResponse.setIdParent(eleve.getParent().getId());*/
        personneResponse.setParent(eleve.getParent());
        personneResponse.setSanctionList(eleve.getSanctionList());
        personneResponse.setAbsenceList(eleve.getAbsenceList());

        return personneResponse;
    }
}
