package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Personne;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.repository.business.EleveRepository;
import com.ibecole.ibecole.repository.business.ParentRepository;
import com.ibecole.ibecole.repository.business.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Autowired
    ConversionService conversionService;

    public Personne save(PersonneRequest personneRequest){
        switch (personneRequest.getType()){
            case "Eleve":{
                Eleve eleve = conversionService.convert(personneRequest, Eleve.class);
                eleveRepository.save(eleve);
                return eleve;
            }
            case "Parent":{
                Parent parent = conversionService.convert(personneRequest, Parent.class);
                parentRepository.save(parent);
                return parent;
            }
            case "Professeu":{
                Professeur professeur = conversionService.convert(personneRequest, Professeur.class);
                professeurRepository.save(professeur);
                return professeur;
            }
            default: return null;
        }
    }


}
