package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Formation;
import com.ibecole.ibecole.entity.business.Niveau;
import com.ibecole.ibecole.repository.business.FormationRepository;
import com.ibecole.ibecole.repository.business.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository= formationRepository;
    }


    public Formation save(Formation formation){
        return formationRepository.save(formation);
    }

    public boolean delete(Integer id){
        formationRepository.deleteById(id);
        return true;
    }

    public Formation findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return formationRepository.getOne(id);
    }

    public List<Formation> findAll(){
        return formationRepository.findAll();
    }

}
