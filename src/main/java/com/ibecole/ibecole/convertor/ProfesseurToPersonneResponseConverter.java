package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.model.response.PersonneResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class ProfesseurToPersonneResponseConverter implements Converter<Parent, PersonneResponse> {
    @Nullable
    @Override
    public PersonneResponse convert(Parent parent) {
        PersonneResponse personneResponse = new PersonneResponse();
        personneResponse.setNom(parent.getNom());
        personneResponse.setPrenom(parent.getPrenom());
        personneResponse.setSexe(parent.getSexe().getLibelle());
        personneResponse.setDateNaissance(parent.getDateNaissance());
        personneResponse.setLieuNaissance(parent.getLieuNaissance());
        personneResponse.setAdresse(parent.getAdresse());
        personneResponse.setTelephone(parent.getTelephone());
        personneResponse.setEmail(parent.getEmail());/*
        personneResponse.setPhoto(parent.getPhoto());*/


        return personneResponse;
    }
}
