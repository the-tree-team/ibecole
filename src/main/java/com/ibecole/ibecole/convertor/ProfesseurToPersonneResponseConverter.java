package com.ibecole.ibecole.convertor;

import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.model.response.PersonneResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class ProfesseurToPersonneResponseConverter implements Converter<Professeur, PersonneResponse> {
    @Nullable
    @Override
    public PersonneResponse convert(Professeur professeur) {
        PersonneResponse personneResponse = new PersonneResponse();
        personneResponse.setNom(professeur.getNom());
        personneResponse.setPrenom(professeur.getPrenom());
        personneResponse.setSexe(professeur.getSexe().getLibelle());
        personneResponse.setDateNaissance(professeur.getDateNaissance());
        personneResponse.setLieuNaissance(professeur.getLieuNaissance());
        personneResponse.setAdresse(professeur.getAdresse());
        personneResponse.setTelephone(professeur.getTelephone());
        personneResponse.setEmail(professeur.getEmail());
        personneResponse.setPhoto(professeur.getPhoto());

        if(professeur.getId()!=null){
            personneResponse.setId(professeur.getId());
        }

        return personneResponse;
    }
}
