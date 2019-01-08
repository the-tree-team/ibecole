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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneService {

    private final EleveRepository eleveRepository;

    private final ParentRepository parentRepository;

    private final ProfesseurRepository professeurRepository;

    private final
    MatriculeGenerate matriculeGenerate;

    private final
    ConversionService conversionService;

    private final
    EnseignerService enseignerService;

    private Eleve eleve;
    private Parent parent;
    private Professeur professeur;

    @Autowired
    public PersonneService(EleveRepository eleveRepository, ParentRepository parentRepository, ProfesseurRepository professeurRepository, @MatGeneration(MatGeneration.typeMat.ELEVE) MatriculeGenerate matriculeGenerate, ConversionService conversionService, EnseignerService enseignerService) {
        this.eleveRepository = eleveRepository;
        this.parentRepository = parentRepository;
        this.professeurRepository = professeurRepository;
        this.matriculeGenerate = matriculeGenerate;
        this.conversionService = conversionService;
        this.enseignerService = enseignerService;
    }

    public Personne save(PersonneRequest personneRequest){
        switch (personneRequest.getType()){
            case "Eleve":{
                eleve = conversionService.convert(personneRequest, Eleve.class);
                eleve.setMatricule(matriculeGenerate.Generate(personneRequest));
                if(personneRequest.getParent()!=null){
                    System.out.println("PARENT-Request-ID: "+ personneRequest.getId());

                    Parent parent = conversionService.convert(personneRequest.getParent(), Parent.class);
                    eleve.setParent(parent);
                    System.out.println("PARENT-ID: "+ parent.getId());
                }
                if(eleve != null)
                    eleve = eleveRepository.save(eleve);
                return eleve;
            }
            case "Parent":{
                System.out.println("PARENT SERVICE");
                parent = conversionService.convert(personneRequest, Parent.class);
                if(personneRequest.getEnfantList()!=null){
                parent.setEnfantList(
                            personneRequest.getEnfantList()
                                    .stream()
                                    .map(item -> {
                                    Eleve eleve=conversionService.convert(item, Eleve.class);
                                    eleve.setParent(parent);
                                        System.out.println("ELEVE:"+eleve.getId());
                                    return eleve;
                                    })
                                    .collect(Collectors.toList())
                    );
                    System.out.println(parent.getEnfantList().size());
                }
                if(parent != null)
                    parent=parentRepository.save(parent);
                return parent;
            }
            case "Professeur":{
                professeur = conversionService.convert(personneRequest, Professeur.class);
                if(professeur != null)
                    professeur = professeurRepository.save(professeur);
                //ICI QU'ON PERSISTE LA LISTE DES MATIERES EN RELATION AVEC LE PROFESSEUR
                enseignerService.save(personneRequest.getMatiereList(),professeur);
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

    public Page<Eleve> findAllEleve(Pageable pageable){
        return eleveRepository.findAll(pageable);
    }
    public Page<Parent> findAllParent(Pageable pageable){
        return parentRepository.findAll(pageable);
    }
    public Page<Professeur> findAllProfesseur(Pageable pageable){
        return professeurRepository.findAll(pageable);
    }
}