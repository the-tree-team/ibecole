package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.commun.qualifier.MatGeneration;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Personne;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.repository.business.EleveRepository;
import com.ibecole.ibecole.repository.business.ParentRepository;
import com.ibecole.ibecole.repository.business.ProfesseurRepository;
import com.ibecole.ibecole.service.business.matGenerate.MatriculeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    private final EleveRepository eleveRepository;

    private final ParentRepository parentRepository;

    private final ProfesseurRepository professeurRepository;

    private final
    MatriculeGenerate matriculeGenerate;

    private final
    ConversionService conversionService;

    private Eleve eleve;
    private Parent parent;
    private Professeur professeur;

    @Autowired
    public PersonneService(EleveRepository eleveRepository, ParentRepository parentRepository, ProfesseurRepository professeurRepository, @MatGeneration(MatGeneration.typeMat.ELEVE) MatriculeGenerate matriculeGenerate, ConversionService conversionService) {
        this.eleveRepository = eleveRepository;
        this.parentRepository = parentRepository;
        this.professeurRepository = professeurRepository;
        this.matriculeGenerate = matriculeGenerate;
        this.conversionService = conversionService;
    }

    public Personne save(PersonneRequest personneRequest){
        switch (personneRequest.getType()){
            case "Eleve":{
                personneRequest.setMatricule(matriculeGenerate.Generate(personneRequest));
                eleve = conversionService.convert(personneRequest, Eleve.class);
                if(eleve != null)
                    eleveRepository.save(eleve);
                return eleve;
            }
            case "Parent":{
                parent = conversionService.convert(personneRequest, Parent.class);
                if(parent != null)
                    parentRepository.save(parent);
                return parent;
            }
            case "Professeur":{
                professeur = conversionService.convert(personneRequest, Professeur.class);
                if(professeur != null)
                    professeurRepository.save(professeur);
                return professeur;
            }
            default: return null;
        }
    }

    public boolean delete(Integer id, String type){
        switch (type){
            case "Eleve":{
                eleveRepository.deleteById(id);
                return true;
            }
            case "Parent":{
                parentRepository.deleteById(id);
                return true;
            }
            case "Professeur":{
                professeurRepository.deleteById(id);
                return true;
            }
            default: return false;
        }
    }
    public Personne findById(Integer id, String type){
        switch (type){
            case "Eleve":{
                eleve = eleveRepository.getOne(id);
                return eleve;
            }
            case "Parent":{
                parent = parentRepository.getOne(id);
                return parent;
            }
            case "Professeur":{
                professeur = professeurRepository.getOne(id);
                return professeur;
            }
            default: return null;
        }
    }

    public List<Eleve> findAllEleve(){
        return eleveRepository.findAll();
    }
    public List<Parent> findAllParent(){
        return parentRepository.findAll();
    }
    public List<Professeur> findAllProfesseur(){
        return professeurRepository.findAll();
    }
}