package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.commun.qualifier.MatGeneration;
import com.ibecole.ibecole.entity.business.Groupe;
import com.ibecole.ibecole.model.request.GroupeRequest;
import com.ibecole.ibecole.repository.business.GroupeRepository;
import com.ibecole.ibecole.repository.business.ParentRepository;
import com.ibecole.ibecole.repository.business.ProfesseurRepository;
import com.ibecole.ibecole.service.business.matGenerate.MatriculeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {

    private final GroupeRepository groupeRepository;

    private final ParentRepository parentRepository;

    private final ProfesseurRepository professeurRepository;

    private final
    MatriculeGenerate matriculeGenerate;

    private final
    ConversionService conversionService;

    private Groupe groupe;

    @Autowired
    public SeanceService(GroupeRepository groupeRepository, ParentRepository parentRepository, ProfesseurRepository professeurRepository, @MatGeneration(MatGeneration.typeMat.ELEVE) MatriculeGenerate matriculeGenerate, ConversionService conversionService) {
        this.groupeRepository = groupeRepository;
        this.parentRepository = parentRepository;
        this.professeurRepository = professeurRepository;
        this.matriculeGenerate = matriculeGenerate;
        this.conversionService = conversionService;
    }

    public Groupe save(GroupeRequest groupeRequest){

                groupe = conversionService.convert(groupeRequest, Groupe.class);
                if(groupe != null)
                    groupeRepository.save(groupe);
                return groupe;



    }

    public boolean delete(Integer id ){
                groupeRepository.deleteById(id);
                return true;

    }
    public Groupe findById(Integer id ){

                groupe = groupeRepository.getOne(id);
                return groupe;

    }

    public List<Groupe> findAllGroupe(){
        return groupeRepository.findAll();
    }
}